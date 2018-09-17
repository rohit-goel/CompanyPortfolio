package com.CompanyPortfolio.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CompanyPortfolio.Entity.CompanyEntity;

/**
 * @author rohit
 *
 */
@Repository
public interface CompanyRepository extends CrudRepository<CompanyEntity, Long> {

	CompanyEntity findByCompanyName(String companyName);

}
