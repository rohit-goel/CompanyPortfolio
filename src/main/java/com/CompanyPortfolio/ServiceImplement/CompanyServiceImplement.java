package com.CompanyPortfolio.ServiceImplement;

import java.util.ArrayList;
import java.util.Iterator;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CompanyPortfolio.Entity.AddressEntity;
import com.CompanyPortfolio.Entity.CompanyEntity;
import com.CompanyPortfolio.Model.CompanyMV;
import com.CompanyPortfolio.Model.CompanyVM;
import com.CompanyPortfolio.Repository.AddressRepository;
import com.CompanyPortfolio.Repository.CompanyRepository;
import com.CompanyPortfolio.Service.CompanyService;

/**
 * @author rohit
 *
 */
@Service
public class CompanyServiceImplement implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public CompanyMV saveCompany(CompanyVM companyVM) {

		AddressEntity addressEntity = modelMapper.map(companyVM.getAddress(), AddressEntity.class);
		addressEntity = addressRepository.save(addressEntity);
		CompanyEntity companyEntity = modelMapper.map(companyVM, CompanyEntity.class);
		companyEntity.setAddress(addressEntity);
		companyEntity = companyRepository.save(companyEntity);
		return modelMapper.map(companyEntity, CompanyMV.class);
	}

	@Override
	public ArrayList<CompanyMV> getCompany() {
		ArrayList<CompanyEntity> companyEntity = (ArrayList<CompanyEntity>) companyRepository.findAll();
		Iterator<CompanyEntity> itr = companyEntity.iterator();
		ArrayList<CompanyMV> list = new ArrayList<>();

		while (itr.hasNext()) {
			list.add(modelMapper.map(itr.next(), CompanyMV.class));
		}
		return list;
	}

	@Override
	public CompanyMV findByName(String companyName) {
		CompanyEntity companyEntity = companyRepository.findByCompanyName(companyName);
		return modelMapper.map(companyEntity, CompanyMV.class);
	}
}
