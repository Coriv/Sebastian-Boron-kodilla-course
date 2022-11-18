package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RepositoriesFacadeTestSuite {

    @Autowired
    private RepositoriesFacade repositoriesFacade;

    @Test
    public void findByPartOfNameTest() {
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        repositoriesFacade.addCompany(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        repositoriesFacade.addCompany(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        repositoriesFacade.addCompany(greyMatter);
        int greyMatterId = greyMatter.getId();

        List<Employee> employees = repositoriesFacade.findEmployeesWithPartOfName("arc");
        List<Company> companies = repositoriesFacade.findCompaniesWithPartOfName("chi");

        //Then
        assertEquals(1, employees.size());
        assertEquals(1, companies.size());

        //CleanUp
        try {
            repositoriesFacade.deleteCompany(softwareMachineId);
            repositoriesFacade.deleteCompany(dataMaestersId);
            repositoriesFacade.deleteCompany(greyMatterId);
        } catch (Exception e) {
        }
    }
}
