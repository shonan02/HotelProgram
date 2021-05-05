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
public class Room {
    
    private int guestNo;
    private Person payingGuest;
    private Boolean occupied;
    
    /**
     * This is the class constructor for the Room class.
     * @param payingGuest Customer information.
     * @param guestNo Number of guests in the room.
     */
    public Room(Person payingGuest, int guestNo) 
    {
        this.payingGuest = payingGuest; //Name of the paying guest
        this.guestNo = guestNo; //Number of guests in the room
        this.occupied = true; //Room is occupied
    }

    /**
     * This is the default class constructor for when the room is empty
     * Occupied is declared false.
     */ 
    public Room() 
    {
        this.occupied = false; //Room is empty   
    }
    
    /**
     * This method is used to set the first and last name of the customer.
     * @param firstName First name.
     * @param lastName Last name. 
     */
    public void setName(String firstName, String lastName) 
    {
        payingGuest.setFirstName(firstName);
        payingGuest.setLastName(lastName);
    }

    //Get method to return the name of the paying guest
    public String getName()
    {
        return payingGuest.getFullName();
    }

    //Getter method to check whether a room is empty or not
    public boolean getStatus() 
    {
        return occupied;
    }
    
    //Getter method to get the number of guests in each room
    public int GetGuestsNo() 
    {
        return guestNo;
    }
    
    //Getter method to return card number
    public String getCardNum() 
    {
        return payingGuest.getCardNum();
    }
    
    public String getPhoneNumber() 
    {
        return payingGuest.getPhoneNumber();
    }
}
