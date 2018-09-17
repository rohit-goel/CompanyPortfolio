package com.CompanyPortfolio.ServiceImplement;

import java.util.ArrayList;
import java.util.Iterator;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CompanyPortfolio.Entity.CompanyEntity;
import com.CompanyPortfolio.Entity.PortfolioEntity;
import com.CompanyPortfolio.Model.PortfolioMV;
import com.CompanyPortfolio.Model.PortfolioVM;
import com.CompanyPortfolio.Repository.CompanyRepository;
import com.CompanyPortfolio.Repository.PortfolioRepository;
import com.CompanyPortfolio.Service.PortfolioService;

/**
 * @author rohit
 *
 */

@Service
public class PortfolioServiceImplement implements PortfolioService {

	@Autowired
	private PortfolioRepository portfolioRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * save portfolio method
	 */
	@Override
	public PortfolioMV savePortfolio(PortfolioVM portfolioVM, String companyName) {

		// find company by companyname
		CompanyEntity companyEntity = companyRepository.findByCompanyName(companyName);

		// set data from viewmodel to entity
		PortfolioEntity portfolioEntity = modelMapper.map(portfolioVM, PortfolioEntity.class);

		// set company to portfolio by name
		portfolioEntity.setCompanyEntity(companyEntity);

		// save data to the portfolio
		portfolioEntity = portfolioRepository.save(portfolioEntity);
		return modelMapper.map(portfolioEntity, PortfolioMV.class);

	}

	/**
	 * get portfolio method
	 */
	@Override
	public ArrayList<PortfolioMV> getPortfolio(String companyName) {
		// find all portfolios according to company name
		ArrayList<PortfolioEntity> portfolioEntity = (ArrayList<PortfolioEntity>) portfolioRepository.findAll();

		// iterator is created of type portfolio
		Iterator<PortfolioEntity> itr = portfolioEntity.iterator();

		ArrayList<PortfolioMV> list = new ArrayList<>();

		while (itr.hasNext()) {
			list.add(modelMapper.map(itr.next(), PortfolioMV.class));
		}
		return list;

	}

	/**
	 * get portfolio by companyname and portfolioid
	 */
	@Override
	public PortfolioMV displayPortfolio(String companyName, Long portfolioId) {
		CompanyEntity companyEntity = companyRepository.findByCompanyName(companyName);
		PortfolioEntity portfolioEntity = portfolioRepository.findByPortfolioIdAndCompanyEntity(portfolioId,
				companyEntity);
		return modelMapper.map(portfolioEntity, PortfolioMV.class);
	}

}
