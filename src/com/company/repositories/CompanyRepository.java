package com.company.repositories;

import com.company.data.IDB;
import com.company.entity.Employee;
import com.company.repositories.ICompanyRepository;

import java.sql.*;
import java.time.LocalDate;

public class CompanyRepository implements ICompanyRepository{ //имплементим interface for using existing methods
    private final IDB dbM; 

    public CompanyRepository(IDB dbM) {
        this.dbM = dbM;
    }

    Employee employee=new Employee(); // создаем общий показной объект

    @Override
    public Employee getEmployeeById(int id) throws SQLException, ClassNotFoundException {
        Connection y = null;
        try {
            y = dbM.con(); // используем существующий метод из IDB в параметре Connection
            String sql = "SELECT  * FROM itcomp;"; //сохраняем код для sql в параметре "sql"
            Statement x = y.createStatement(); //говорим что x теперь будет методом createStatement
            ResultSet res = x.executeQuery(sql); // ResultSet предоставляет ответ из БД, и мы присываем к нему наш executive code "sql"
            while (res.next()) { // пока наш ответ имеет следующие значение, it will work
                int uniq_id = res.getInt("uniq_id"); // следующим 6 строк не необходимо объяснение, мы просто присываем к новым атрибутам значение из БД
                String firstName = res.getString("firstName");
                String secondName = res.getString("secondName");
                int password = res.getInt("password");
                String jobPosition = res.getString("jobPosition");
                int salary = res.getInt("salary");
                if (uniq_id == id) { // если наш "uniq_id" из БД равен преписыванному id просто выводим attributes above
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Unique ID -  " + uniq_id);
                    System.out.println("First Name - " + firstName);
                    System.out.println("Second Name - " + secondName);
                    System.out.println("Password - " + password);
                    System.out.println("Job Position - " + jobPosition);
                    System.out.println("Salary - " + salary);
                    System.out.println("--------------------------------------------------------------");
                    Employee cur = new Employee(uniq_id, firstName, secondName, password, jobPosition, salary); // используем новый объект Employee с названием cur (current), чтобы в вывести его ниже преписным кодом
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
            y = dbM.con(); //используем существующий метод из IDB в параметре Connection
            char quote = (char)39; // quotes in ASCII(char) Table to use it in the inserting statement
            int newId = employee.getUniq_id(); // используем getпараметр для приравневыванию его к новым пустым значением
            String newFirstName = employee.getFirstName(); // используем getпараметр для приравневыванию его к новым пустым значением
            String newSecondName = employee.getSecondName(); // используем getпараметр для приравневыванию его к новым пустым значением
            int newPassword= employee.getPassword(); // используем getпараметр для приравневыванию его к новым пустым значением
            String newJobPosition = employee.getJobPosition(); // используем getпараметр для приравневыванию его к новым пустым значением
            int newSalary = employee.getSalary(); // используем getпараметр для приравневыванию его к новым пустым значением
            Statement x = y.createStatement(); //говорим что x теперь будет методом createStatement

            x.executeUpdate("Insert into itcomp " + "values(" + newId + ", " + quote + newFirstName + quote + ", " + quote + newSecondName + quote + ", " + newPassword + ", " + quote + newJobPosition + quote + ", " + newSalary + ");");
            // экзикьютим код в соответсвующей форме "Insert into itcomp VALUES int, "String", "String", int ... ;"

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
            y = dbM.con(); //используем существующий метод из IDB в параметре Connection
            String sql = "DELETE from itcomp WHERE uniq_id=" + id + ";"; // создаем новый sql code записывая его в пустое значение "sql"
            PreparedStatement x = y.prepareStatement(sql);  //говорим что x теперь будет методом prepareStatement
            x.execute(); //экзекьютим наш sql code
            return true;
        } catch (SQLException throwables) { //если не работает, то ловим exception(-ы)
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
