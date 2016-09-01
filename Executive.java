package CMIS242Project1;

/**
* File: Executive.java
* Author: Anthony Argento
* Date: 8/31/16
* Purpose: Define a subclass of the Week 2 project Includes 2 override methods
* to return annual salary and toString method for report.
*/

class Executive extends Employee{
    
    //define class variables
    private final int BONUS = 30000;
    private int stockPrice;
    private int totalSalary;
    
    //constructor
    Executive(String employeeType, String employeeName, int monthlySalary, int stockPrice){
        super(employeeType, employeeName, monthlySalary);
        this.stockPrice = stockPrice;
    }
    
    public void getStockPrice(int stockPrice){
        this.stockPrice = stockPrice;
    }
    
    @Override
    public int annualSalary(int monthlySalary){
        if (stockPrice < 50){
            totalSalary = super.annualSalary(monthlySalary);
            return totalSalary;
        } else {
            totalSalary = (super.annualSalary(monthlySalary) + BONUS);
            return totalSalary;
        }
    }
    
    //override toString method to add executive specific data
    @Override
    public String toString(){
        return super.toString() + "\n\tStock Price: " + 
                currencyFormatter.format(stockPrice);
            
    }
}
