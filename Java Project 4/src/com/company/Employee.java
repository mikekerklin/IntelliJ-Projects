package com.company;// Employee.java

// Employee abstract superclass.

 

public abstract class Employee

{

   private String firstName;

   private String lastName;

   private String socialSecurityNumber;

   public Date getBirthday() {
      return birthday;
   }

   public void setBirthday(Date birthday) {
      this.birthday = birthday;
   }

   private Date birthday;

 

   // three-argument constructor

   public Employee( String first, String last, String ssn, Date birthday )

   {

      firstName = first;

      lastName = last;

      socialSecurityNumber = ssn;

      this.birthday=birthday;

   } // end three-argument Employee constructor

 

   // set first name

   public void setFirstName( String first )

   {

      firstName = first;

   } // end method setFirstName

 

   // return first name

   public String getFirstName()

   {

      return firstName;

   } // end method getFirstName

 

   // set last name

   public void setLastName( String last )

   {

      lastName = last;

   } // end method setLastName

 

   // return last name

   public String getLastName()

   {

      return lastName;

   } // end method getLastName

 

   // set social security number

   public void setSocialSecurityNumber( String ssn )

   {

      socialSecurityNumber = ssn; // should validate

   } // end method setSocialSecurityNumber

 

   // return social security number

   public String getSocialSecurityNumber()

   {

      return socialSecurityNumber;

   } // end method getSocialSecurityNumber

 

   // return String representation of Employee object

   public String toString()

   {

      return String.format( "%s %s\nsocial security number: %s\nbirthday: %s",

         getFirstName(), getLastName(), getSocialSecurityNumber(),getBirthday() );

   } // end method toString

 

   // abstract method overridden by subclasses

   public abstract double earnings(); // no implementation here

} // end abstract class Employee