package com.company.controllers;

import com.company.entity.Employee;
import com.company.repositories.ICompanyRepository;

import java.sql.SQLException;

public class CompanyController {
    private final ICompanyRepository reposit;

    public CompanyController(ICompanyRepository reposit) {
        this.reposit = reposit;
    }



    public String addEmployee(int newId, String newFirstName, String newSecondName, int newPassword, String newjobPosition, int newSalary) throws SQLException, ClassNotFoundException {

        boolean add = reposit.addEmployee(new Employee(newId, newFirstName, newSecondName, newPassword,newjobPosition, newSalary));

        if (add) {
            return "Well Done! You added a new employee.";
        } else {
            return "Inserting a row completed with an error, please try it again with the right order!";
        }
    }

    public Employee getEmployeeById(int target) throws SQLException, ClassNotFoundException {
        Employee result = reposit.getEmployeeById(target);
        return result;
    }

    public String removeEmployeeById(int id) {
        boolean dlt = reposit.removeEmployeeById(id);

        if (dlt) {
            return "You have removed an employee!";
        } else {
            return "The removing has completed with an error!";
        }
    }


}
