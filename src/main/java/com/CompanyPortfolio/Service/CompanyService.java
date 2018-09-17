package com.CompanyPortfolio.Service;

import java.util.ArrayList;

import com.CompanyPortfolio.Model.CompanyMV;
import com.CompanyPortfolio.Model.CompanyVM;

/**
 * @author rohit
 *
 */
public interface CompanyService {

	CompanyMV saveCompany(CompanyVM companyVM);

	ArrayList<CompanyMV> getCompany();

	CompanyMV findByName(String companyName);

}
