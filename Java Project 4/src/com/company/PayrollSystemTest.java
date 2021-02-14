package com.company;// PayrollSystemTest.java
//Mike Kerklin
//Java Program #4
//Payroll
//CS 2265-XTIA – Advanced Programming I

   import java.util.Scanner;
 

public class PayrollSystemTest

{

   public static void main( String args[] )

   {

      // create subclass objects
       Scanner input = new Scanner(System.in);
       int bonusMonth=11;
       Employee[] employees=new Employee[5];
       
       for(int i=0;i<5;i++){
       
       String firstName;
       String lastName;
       String socialSecurityNumber;
       double salary;
       int birthDay;
       int birthMonth;
       int birthYear;
       int hoursWorked;
       double commission;
       double hourlyRate;
       double totalSales;
       
      
      
      System.out.print("Please input employee first name: ");
      firstName=input.nextLine();
      System.out.print("Please input employee last name: ");
      lastName=input.nextLine();
      System.out.print("Please input employee social security number: ");
      socialSecurityNumber=input.nextLine();
      System.out.print("Please input employee birth year: ");
      birthYear=Integer.parseInt(input.nextLine());
      System.out.print("Please input employee birth month: ");
      birthMonth=Integer.parseInt(input.nextLine());
      System.out.print("Please input employee birth day: ");
      birthDay=Integer.parseInt(input.nextLine());
      Date birthday=new Date(birthMonth,birthDay,birthYear);
      System.out.print("What is the employee type?\n1=hourly, 2=salary, 3=commissioned, 4=base + commission: ");
      int employeeType=Integer.parseInt(input.nextLine());


      switch (employeeType)
      {
         case 1:System.out.print("Please enter the number of hours worked: ");
                hoursWorked=Integer.parseInt(input.nextLine());
                System.out.print("Please enter the hourly pay rate: ");
                hourlyRate=Double.parseDouble(input.nextLine());
                employees[i] = new HourlyEmployee(firstName,lastName,socialSecurityNumber,birthday,hoursWorked,hourlyRate);
                        
         break;
         
         case 2:System.out.print("Please enter the weekly salary: ");
                salary=Double.parseDouble(input.nextLine());
                employees[i] = new SalariedEmployee(firstName,lastName,socialSecurityNumber,birthday,salary);
                         
         break;
         
         case 3:System.out.print("Please enter the total sales made: ");
                totalSales=Double.parseDouble(input.nextLine());
                System.out.print("Please enter the commission rate: ");
                commission=Double.parseDouble(input.nextLine());
                employees[i] = new CommissionEmployee(firstName,lastName,socialSecurityNumber,birthday,totalSales,commission);
                          
         break;

          case 4:System.out.print("Please enter the base salary: ");
                  salary= Double.parseDouble(input.nextLine());
                  System.out.print("Please enter the total sales made: ");
                  totalSales= Double.parseDouble(input.nextLine());
                  System.out.print("Please enter the commission rate: ");
                  commission= Double.parseDouble(input.nextLine());
                  employees[i]=new BasePlusCommissionEmployee(firstName,lastName,socialSecurityNumber,birthday,totalSales,commission,salary);
          break;

         default:
                
}
      System.out.println("");
}
     
 

      System.out.println( "Employees processed individually:\n" );

       for(int i=0;i<5;i++) {

           System.out.printf("%s\n%s: $%,.2f\n\n",

                   employees[i], "earned", employees[i].earnings());

       }
      System.out.println( "Employees processed polymorphically:\n" );

     

      // generically process each element in array employees

      for ( Employee currentEmployee : employees )

      {

         System.out.println( currentEmployee ); // invokes toString

 

         // determine whether element is a BasePlusCommissionEmployee

         if ( currentEmployee instanceof BasePlusCommissionEmployee )

         {

            // downcast Employee reference to

            // BasePlusCommissionEmployee reference

            BasePlusCommissionEmployee employee =

               ( BasePlusCommissionEmployee ) currentEmployee;

 

            double oldBaseSalary = employee.getBaseSalary();

            employee.setBaseSalary( 1.10 * oldBaseSalary );

            System.out.printf(

               "New base salary with 10%% increase is: $%,.2f\n",

               employee.getBaseSalary() );

         } // end if

 

         System.out.printf(

            "Earned $%,.2f\n\n", currentEmployee.earnings() );
         int bonus=0;
         if(currentEmployee.getBirthday().compareMonth(bonusMonth)){
             bonus=100;
         }
         System.out.printf(

                  "Earned monthly $%,.2f\n\n", currentEmployee.earnings()*4+bonus );
      } // end for

 

      // get type name of each object in employees array

      for ( int j = 0; j < employees.length; j++ )

         System.out.printf( "Employee %d is a %s\n", j,

            employees[ j ].getClass().getName() );

   } // end main

} // end class PayrollSystemTest