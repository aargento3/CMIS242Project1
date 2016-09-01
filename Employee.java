package CMIS242Project1;

 /**
* File: Employee.java
* Author: Anthony Argento
* Date: 8/31/16
* Purpose: Define the super class of the Week 2 project Includes method
* to return annual salary and toString method for report.
*/

import java.text.NumberFormat;
import java.util.Locale;
 
class Employee {
    
    //define variables
    private final int monthlySalary;
    private final String employeeName;
    private final String employeeType;
    
    //define format for all dollar amounts in super and subclasses
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
    
    //constructor
    public Employee (String employeeType, String employeeName, int monthlySalary){
        this.employeeType = employeeType;
        this.employeeName = employeeName;
        this.monthlySalary = monthlySalary;
    }
    
    //method to return annualSalary 
    public int annualSalary(int monthlySalary){
        return (monthlySalary * 12);
    }
    
    //toString method to return employee name and annual salary
    @Override
    public String toString(){
       return employeeType + ": " + employeeName + "\n\tMonthly Salary: " +
               currencyFormatter.format(monthlySalary) + "\n\tAnnual Salary: " +  
               currencyFormatter.format(annualSalary(monthlySalary));
    }
    
}