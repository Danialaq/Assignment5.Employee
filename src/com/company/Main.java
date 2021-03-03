package com.company;

import com.company.controllers.CompanyController;
import com.company.data.DB;
import com.company.data.IDB;
import com.company.repositories.CompanyRepository;

import java.sql.SQLException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException, SQLException, ClassNotFoundException {
        IDB dbM = new DB();
        CompanyRepository reposit = new CompanyRepository(dbM);
        CompanyController ctrl = new CompanyController(reposit);
        Application myApp = new Application(ctrl);
        myApp.start();

    }
}
