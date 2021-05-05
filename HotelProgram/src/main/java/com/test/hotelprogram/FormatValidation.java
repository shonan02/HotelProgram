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
public class FormatValidation {
    
    public enum Error 
    {
        PHONE, 
        CREDIT,
        NAME     
    }
    
    /**
     * This method is used to validate the users information when trying to book a new room.
     * @param phone The users phone number.
     * @param cardNum The users credit card number.
     * @param fname The users first name.
     * @param lname The users last name.
     * @return True or false, whether the users input is valid or not.
     */
    public boolean validateUserInfo(String phone, String cardNum, String fname, String lname)
    {
        if(!validateName(fname) || !validateName(lname))
        { System.out.println("Error:" + Error.NAME); return false; }
        else if (!validatePhone(phone))
        { System.out.println("Error: " + Error.PHONE);return false; }
        else if (!validateCreditCardNumber(cardNum))
        { System.out.println("Error: " + Error.CREDIT); return false; }
        else { return true; }
    }
    
    /**
     * This method is used to validate a users phone number
     * Has to be 11 characters.
     * @param phone The users phone number.
     * @return True or false.
     */
    private boolean validatePhone(String phone)
    {
        return phone.length() == 11;     
    }
    
    /**
     * This method is used for validating the users credit card number
     * Has to be 16 characters.
     * @param cardNum Users credit card number.
     * @return true or false.
     */
    private boolean validateCreditCardNumber(String cardNum)
    {
        return cardNum.length() == 16; 
    }
    
    /**
     * This method is used to validate a name inputted
     * Must not be empty and match the letters in the alphabet.
     * @param name Users first or last name.
     * @return true or false.
     */
    private boolean validateName(String name)
    {
        if(isEmpty(name)){ return false; }
        else { return name.matches("[a-zA-z]+"); }
    }
    
    /**
     * This method is used to check whether a string is empty.
     * @param string A string of any length or characters.
     * @return true or false.
     */
    private boolean isEmpty(String string)
    {
        return string.equals("");
    }
}
