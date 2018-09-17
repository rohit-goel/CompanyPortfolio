package com.CompanyPortfolio.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CompanyPortfolio.Model.PortfolioMV;
import com.CompanyPortfolio.Model.PortfolioVM;
import com.CompanyPortfolio.Service.PortfolioService;

/**
 * @author rohit
 *
 */
@RestController
@RequestMapping("/company/{companyName}/portfolio")
public class PortfolioController {

	@Autowired
	private PortfolioService portfolioService;

	/**
	 * POST MAPPING
	 */
	@PostMapping("/saveportfolio")
	public PortfolioMV savePortfolio(@RequestBody PortfolioVM portfolioVM,
			@PathVariable("companyName") String companyName) {
		return portfolioService.savePortfolio(portfolioVM, companyName);
	}

	/**
	 * GET MAPPING
	 */
	@GetMapping("/getportfolio")
	public ArrayList<PortfolioMV> getPortfolio(@PathVariable("companyName") String companyName) {
		return portfolioService.getPortfolio(companyName);
	}

	/**
	 * GET MAPING BY PRTFOLIOID
	 */
	@GetMapping("/getportfoliobyid")
	public PortfolioMV displayPortfolio(@PathVariable("companyName") String companyName,
			@RequestParam(value = "portfolioId", required = true) Long portfolioId) {
		return portfolioService.displayPortfolio(companyName, portfolioId);
	}
}
