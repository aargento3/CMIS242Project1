package CMIS242Project1;

/**
* File: Salesman.java
* Author: Anthony Argento
* Date: 8/31/16
* Purpose: Define a subclass of the Week 2 project Includes 2 override methods
* to return annual salary and toString method for report.
*/

class Salesman extends Employee{
    
    //define class variables
    private int annualSales;
    private int commission;
    private int totalSalary;
    
    //constructor
    Salesman(String employeeType, String employeeName, int monthlySalary, int annualSales){
        super(employeeType, employeeName, monthlySalary);
        this.annualSales = annualSales;
    }
    
    public void getAnnualSales(int annualSales){
        this.annualSales = annualSales;
    }
    
    //method to return annual salary based on annual sales
    @Override
    public int annualSalary(int monthlySalary){
        commission = (int) (this.annualSales * .02);
        
        if (commission > 20000){
            commission = 20000;
        }
        
        totalSalary = (super.annualSalary(monthlySalary) + commission);
        
        return totalSalary;
    }
   
    //override toString method to add salesman specific data 
    @Override
     public String toString(){
        return super.toString() + "\n\tAnnual Sales: " +
              currencyFormatter.format(this.annualSales);      
    }
}