package com.CompanyPortfolio.Service;

import java.util.ArrayList;

import com.CompanyPortfolio.Model.PortfolioMV;
import com.CompanyPortfolio.Model.PortfolioVM;

/**
 * @author rohit
 *
 */
public interface PortfolioService {

	PortfolioMV savePortfolio(PortfolioVM portfolioVM, String companyName);

	ArrayList<PortfolioMV> getPortfolio(String companyName);

	PortfolioMV displayPortfolio(String companyName, Long portfolioId);
}
