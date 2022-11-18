package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepositoriesFacade {

    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    @Autowired
    public RepositoriesFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public List<Company> findCompaniesWithPartOfName(String name) {
        return companyDao.getCompanyByName("%" + name + "%");
    }

    public List<Employee> findEmployeesWithPartOfName(String name) {
        return employeeDao.getByPartOfLastname("%" + name + "%");
    }

    public void addCompany(Company company) {
        companyDao.save(company);
    }

    public void deleteCompany(Integer id) {
        companyDao.deleteById(id);
    }
}