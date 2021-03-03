package com.company.repositories;

import com.company.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ICompanyRepository {
    public Employee getEmployeeById(int id) throws SQLException, ClassNotFoundException;
    public boolean addEmployee(Employee employee) throws SQLException, ClassNotFoundException;
    public boolean removeEmployeeById(int id);
}