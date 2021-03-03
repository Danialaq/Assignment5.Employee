package com.company.repositories;

import com.company.data.IDB;
import com.company.entity.Employee;
import com.company.repositories.ICompanyRepository;

import java.sql.*;
import java.time.LocalDate;

public class CompanyRepository implements ICompanyRepository{
    private final IDB dbM;

    public CompanyRepository(IDB dbM) {
        this.dbM = dbM;
    }

    Employee employee=new Employee();

    @Override
    public Employee getEmployeeById(int id) throws SQLException, ClassNotFoundException {
        Connection y = null;
        try {
            y = dbM.con();
            String sql = "SELECT  * FROM itcomp;";
            Statement x = y.createStatement();
            ResultSet res = x.executeQuery(sql);
            while (res.next()) {
                int uniq_id = res.getInt("uniq_id");
                String firstName = res.getString("firstName");
                String secondName = res.getString("secondName");
                int password = res.getInt("password");
                String jobPosition = res.getString("jobPosition");
                int salary = res.getInt("salary");
                if (uniq_id == id) {
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Unique ID -  " + uniq_id);
                    System.out.println("First Name - " + firstName);
                    System.out.println("Second Name - " + secondName);
                    System.out.println("Password - " + password);
                    System.out.println("Job Position - " + jobPosition);
                    System.out.println("Salary - " + salary);
                    System.out.println("--------------------------------------------------------------");
                    Employee cur = new Employee(uniq_id, firstName, secondName, password, jobPosition, salary);
                    return cur;
                }
            }
            return null;
        } catch (SQLException  throwables) {
            throwables.printStackTrace();
        } finally{
            try {
                y.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean addEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        Connection y= null;
        try {
            y = dbM.con();
            char quote = (char)39; // quotes in ASCII Table to use it in the inserting statement
            int newId = employee.getUniq_id();
            String newFirstName = employee.getFirstName();
            String newSecondName = employee.getSecondName();
            int newPassword= employee.getPassword();
            String newJobPosition = employee.getJobPosition();
            int newSalary = employee.getSalary();
            Statement x = y.createStatement();

            x.executeUpdate("Insert into itcomp " + "values(" + newId + ", " + quote + newFirstName + quote + ", " + quote + newSecondName + quote + ", " + newPassword + ", " + quote + newJobPosition + quote + ", " + newSalary + ");");

            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally{
            try {
                y.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean removeEmployeeById(int id) {
        Connection y = null;
        try {
            y = dbM.con();
            String sql = "DELETE from itcomp WHERE uniq_id=" + id + ";";
            PreparedStatement x = y.prepareStatement(sql);
            x.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                y.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;

    }
}