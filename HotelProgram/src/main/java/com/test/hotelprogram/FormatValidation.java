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
    private boolean validatePhone(String phone)
    {
        if(isEmpty(phone)){ return false; }
        else { return phone.length() == 11; }    
    }
    
    private boolean validateCreditCardNumber(String cardNum)
    {
        if(isEmpty(cardNum)){ return false; }
        else { return cardNum.length() == 16; }
    }
    
    private boolean validateName(String name)
    {
        if(isEmpty(name)){ return false; }
        else { return name.matches("[a-zA-z]+"); }
    }
    
    private boolean isEmpty(String string)
    {
        return string.equals("");
    }
}
