package com.valtech.training.invoiceassignment.components;

import java.util.List;

public interface CompanyDAO {

	long count();

	void createCompany(Company comp);

	void deleteCompany(int compId);

	void updateCompany(Company comp);

	List<Company> getAllCompanies();

	Company getCompanies(int compId);

}