/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.hotelprogram;

/**
 *
 * @author shona
 */
public class Person {
    
    
    private String FirstName;
    private String LastName;
    private String CreditCardNumber;
    
    //Class constructor for the person with three string parameters
    public Person(String fName, String lName, String cardNum) 
    {
        this.FirstName = fName;
        this.LastName = lName;
        this.CreditCardNumber = cardNum;
    }
    
        //Setter method for setting the first name
    public void setFirstName(String FirstName) 
    {
        this.FirstName = FirstName;
    }
    
    //Setter method for setting last name
    public void setLastName(String LastName)
    {
        this.LastName = LastName;
    }

    //Return the name of the paying guest
    public String getFullName() 
    {
        return FirstName + " " + LastName;
    }
    
    //Getter method to return card number
    public String getCardNum() 
    {
        return CreditCardNumber;
    }
    
}
