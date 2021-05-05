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
    private String phoneNumber;
    
    /**
     * Class constructor for the Person class.
     * @param fName First name.
     * @param lName Last name.
     * @param cardNum Credit card number.
     * @param phoneNumber Phone number.
     */
    public Person(String fName, String lName, String cardNum, String phoneNumber) 
    {
        this.FirstName = fName;
        this.LastName = lName;
        this.CreditCardNumber = cardNum;
        this.phoneNumber = phoneNumber;
    }
    
    
    /**
     * This method sets the first name of the object.
     * @param FirstName First name.
     */
    public void setFirstName(String FirstName) 
    {
        this.FirstName = FirstName;
    }
    
    /**
     * This method sets the last name of the Person object.
     * @param LastName 
     */
    public void setLastName(String LastName)
    {
        this.LastName = LastName;
    }

    /**
     * This method is used to return the full name of the person object.
     * @return first and last name concatenated.
     */
    public String getFullName() 
    {
        return FirstName + " " + LastName;
    }
    
    /**
     * This method is used to get the credit card number of the Person object.
     * @return Credit card number.
     */
    public String getCardNum() 
    {
        return CreditCardNumber;
    }
    
    /**
     * This method is used to get the phone number of the Person object.
     * @return Phone number.
     */
    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
}
