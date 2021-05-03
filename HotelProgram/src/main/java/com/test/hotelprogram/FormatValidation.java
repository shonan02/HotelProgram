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
    
    public boolean validatePhone(String phone)
    {
        return phone.length() == 11;
    }
    
    public boolean validateCreditCardNumber(String cardNum)
    {
        return cardNum.length() == 16;
    }
    
    public boolean validateName(String name)
    {
        return name.matches("[a-zA-z]+");
    }
}
