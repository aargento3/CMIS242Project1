package CMIS242Project1;

/**
* File: TestProject1.java
* Author: Anthony Argento
* Date: 8/31/16
* Purpose: Define a test class and main method of the Week 2 project 
* Provides 2 object arrays for storing employee, salesman and executive objects
* Uses Scanner to read in data from the provided file
* Calls the toString and annualSalary methods to provide a report
* Averages all salaries in 2014 and 2015 and provides that data to user.
*/

//import all required
import java.io.*;
import java.text.*;
import java.util.*;


public class TestProject1{
  
    public static void main(String[] args)throws FileNotFoundException {
       
       //define format of dollar amounts
       NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
       
       //variable to hold passed-in argument for Scanner
       String filename = args[0];
       
       //define max size of arrays
       final int SIZE = 20;
       
       //following 2 int used as counters for array
       int employees2014 = 0;
       int employees2015 = 0;

       //constructors
       Employee employee = new Employee("", "", 0);
       Salesman salesman = new Salesman("", "", 0, 0);
       Executive executive = new Executive("", "", 0, 0);
       
       //define arrays
       Object [] data2014 = new Object [SIZE]; 
       Object [] data2015 = new Object [SIZE];
      
       //variables to hold average salaries
       double average2014 = 0, average2015 = 0;
       
       Scanner fileScanner = null;
       
       //variable definition for use in scanner and array portion of code
       int salary;
       int sales;
       int stock;
       double sum2014 = 0; 
       double sum2015 = 0; 
       
       //block of code reads in data from supplied file
       try{
           fileScanner=new Scanner(new File(filename));
        
           while(fileScanner.hasNextLine()){
               int year = fileScanner.nextInt();
               String type = fileScanner.next();
                        
               if(type.equals("Employee") & year == 2014){
                   String name = fileScanner.next();                                      
                   salary = fileScanner.nextInt();
                   sum2014 = sum2014 + employee.annualSalary(salary);
                   data2014[employees2014] = new Employee(type, name, salary);
                   employees2014++;
               }
               else if(type.equals("Employee") & year == 2015){
                   String name = fileScanner.next();                                      
                   salary = fileScanner.nextInt();
                   sum2015 = sum2015 + employee.annualSalary(salary);
                   data2015[employees2015] = new Employee(type, name, salary);
                   employees2015++;
               }              
               else if(type.equals("Salesman")& year == 2014){
                   String name = fileScanner.next();                  
                   salary = fileScanner.nextInt();
                   sales = fileScanner.nextInt();
                   salesman.getAnnualSales(sales);
                   sum2014 = sum2014 + salesman.annualSalary(salary);
                   data2014[employees2014] = new Salesman(type, name, salary, sales);
                   employees2014++;
               }
               else if(type.equals("Salesman")& year == 2015){
                   String name = fileScanner.next();                  
                   salary = fileScanner.nextInt();
                   sales = fileScanner.nextInt(); 
                   salesman.getAnnualSales(sales);
                   sum2015 = sum2015 + salesman.annualSalary(salary);
                   data2015[employees2015] = new Salesman(type, name, salary, sales);
                   employees2015++;
               }
               else if(type.equals("Executive")& year == 2014){
                   String name = fileScanner.next();                  
                   salary = fileScanner.nextInt();
                   stock = fileScanner.nextInt();
                   executive.getStockPrice(stock);
                   sum2014 = sum2014 + executive.annualSalary(salary);
                   data2014[employees2014] = new Executive(type, name, salary, stock);
                   employees2014++;
               }
               else if(type.equals("Executive")& year == 2015){
                   String name = fileScanner.next();                  
                   salary = fileScanner.nextInt();
                   stock = fileScanner.nextInt();
                   executive.getStockPrice(stock);
                   sum2015 = sum2015 + executive.annualSalary(salary);
                   data2015[employees2015] = new Executive(type, name, salary, stock);
                   employees2015++;
               }
           }
           
           //close scanner
           fileScanner.close();
           
        }//end try
       
        catch (FileNotFoundException e){
                System.out.println("Required file not found! \nPlease double check"
                    + " arguments and/or file location! \nProgram will now exit.");
                System.exit(0);
        }//end catch
       
       //report generation 
       System.out.println("Welcome to the Week 2 CMIS 242 Project!");
       
        
        //Results of the 2014 year employees data
        if (employees2014 > 0) {
            average2014 = sum2014/employees2014;
            System.out.println("\n<<< 2014 Members " + "(" + employees2014 + 
                    " total) >>>");
            
            for (int i = 0; i < employees2014; i++){
                System.out.println(data2014[i].toString()); 
            }

            System.out.println("\nAverage Salary for all members in 2014: " 
               + currencyFormatter.format(average2014));
        }//end if statement
        
        //Results of the 2015 year employees data        
        if (employees2015 > 0) {
            average2015 = sum2015/employees2015;
            
            System.out.println("\n<<< 2015 Members " + "(" + employees2015 + 
                    " total) >>>");
            for (int i = 0; i < employees2015; i++){
                System.out.println(data2015[i].toString()); 
            }
            
            System.out.println("\nAverage Salary for all members in 2015: " 
               + currencyFormatter.format(average2015));            
        }//end if statement
    
    }//end main method

} //end TestProject1
        