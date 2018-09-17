package com.CompanyPortfolio.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CompanyPortfolio.Model.CompanyMV;
import com.CompanyPortfolio.Model.CompanyVM;
import com.CompanyPortfolio.Service.CompanyService;

/**
 * @author rohit
 *
 */

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	/**
	 * POST MAPPING
	 */
	@PostMapping("/save")
	public CompanyMV saveCompany(@RequestBody CompanyVM companyVM) {
		return companyService.saveCompany(companyVM);
	}

	/**
	 * GET MAPPING
	 */
	@GetMapping("/getcompany")
	public ArrayList<CompanyMV> getCompany() {
		return companyService.getCompany();
	}

	/**
	 * GET MAPPING BY COMPANYNAME
	 */
	@GetMapping("/companybyname")
	public CompanyMV findByName(@RequestParam(value = "companyName", required = true) String companyName) {
		return companyService.findByName(companyName);
	}

}
