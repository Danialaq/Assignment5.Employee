package com.company;

import com.company.controllers.CompanyController;
import com.company.entity.Employee;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Application {
    private CompanyController ctrl = null;
    private final Scanner input;

    public Application(CompanyController ctrl) {
        this.ctrl = ctrl;
        input = new Scanner(System.in);
    }

    public void start() throws ParseException, SQLException, ClassNotFoundException {
        while (true) {
            System.out.println("You see the select option above, please choose a number");
            System.out.println("1 - To Search An Employee By Its Id");
            System.out.println("2 - To Add An Employee To The Company");
            System.out.println("3 - To Remove An Employee By Its Id");

            int a = input.nextInt(); // inputting the number

            if (a == 1) {
                getEmployeeById();
            }  //checking the num
            else if (a == 2) {
                addEmployee();
            } else if (a == 3) {
                removeEmployeeById();
            } else {
                break;
            }
            System.out.println("------------------------------------------");
        }
    }

    public void getEmployeeById() throws SQLException, ClassNotFoundException {  //inputting the ID for getting it from the DB
        System.out.println("Enter the id of an employee - ");
        int targetId;
        targetId = input.nextInt();
        Employee result = ctrl.getEmployeeById(targetId); // saving the result to remove it
        System.out.println(result.toString());
        input.nextLine();
    }

    public void addEmployee() throws ParseException, SQLException, ClassNotFoundException {  // inputting the ID for adding it to the DB
        System.out.println("Enter New Unique ID - ");  // filling the column
        int newId;
        newId = input.nextInt();
        input.nextLine();
        System.out.println("Enter New First Name - ");
        String newFirstName;
        newFirstName = input.nextLine();
        System.out.println("Enter New Second Name - ");
        String newSecondName;
        newSecondName = input.nextLine();
        System.out.println("Enter New Password - ");
        int newPassword;
        newPassword = input.nextInt();
        input.nextLine();
        System.out.println("Enter New Job Position - ");
        String newJobPosition;
        newJobPosition = input.nextLine();
        System.out.println("Enter New Salary - ");
        int newSalary;
        newSalary = input.nextInt();

        String result = ctrl.addEmployee(newId, newFirstName, newSecondName, newPassword, newJobPosition, newSalary); // saving it as the result with the right order
        System.out.println(result);
        input.nextLine();
    }

    public void removeEmployeeById() {
        System.out.println("Enter the unique id of an employee - ");  // inputting the ID to remove it from the DB
        int id;
        id = input.nextInt();

        String result = ctrl.removeEmployeeById(id);
        System.out.println(result);
    }
}
