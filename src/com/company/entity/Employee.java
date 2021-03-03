package com.company.entity;

public class Employee {
    public int uniq_id;
    public String firstName;
    public String secondName;
    public int password;
    public String jobPosition;
    public int salary;

    public Employee(int uniq_id, String firstName, String secondName, int password, String jobPosition, int salary){
        this();
        setUniq_id(uniq_id);
        setFirstName(firstName);
        setSecondName(secondName);
        setPassword(password);
        setJobPosition(jobPosition);
        setSalary(salary);
    }

    public Employee() {

    }

    public void setUniq_id(int uniq_id) {
        this.uniq_id = uniq_id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getUniq_id() {
        return uniq_id;
    }

    public  String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getPassword() {return password;}

    public String getJobPosition() {return jobPosition;}

    public int getSalary() {return salary;}
    public String toString(){
        return "Employee{id=" + uniq_id + ", firstname=" + firstName + ", secondname=" + secondName + ", password=" + password + ", jobposition=" + jobPosition + ", salary=" + salary + "}\n";
    }

}
