package com.company.repositories;

import com.company.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ICompanyRepository {
    public Employee getEmployeeById(int id) throws SQLException, ClassNotFoundException; // создаем методы в интерфейсе для CompanyRepository и CompanyController, to get all info about an employee 
    public boolean addEmployee(Employee employee) throws SQLException, ClassNotFoundException; //создаем методы в интерфейсе для CompanyRepository и CompanyController, to add a new employee into the database
    public boolean removeEmployeeById(int id); //создаем методы в интерфейсе для CompanyRepository и CompanyController, to delete a row of an employee from itcomp table
}
