package com.CompanyPortfolio.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CompanyPortfolio.Entity.CompanyEntity;
import com.CompanyPortfolio.Entity.PortfolioEntity;

/**
 * @author rohit
 *
 */
@Repository
public interface PortfolioRepository extends CrudRepository<PortfolioEntity, Long> {
	List<PortfolioEntity> findByCompanyEntity(CompanyEntity companyEntity);

	PortfolioEntity findByPortfolioIdAndCompanyEntity(Long portfolioID, CompanyEntity companyEntity);
}
