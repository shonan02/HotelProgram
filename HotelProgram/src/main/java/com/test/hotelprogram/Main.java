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

import java.util.Scanner; 

public class Main {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        Hotel hotel = new Hotel(); //Create hotel object 
        boolean loop = true;
        Scanner input = new Scanner(System.in);
        
        while(loop) {
            hotel.GetMenu();//Disaply main menu
            String answer = input.nextLine(); //GEt user input
            answer = answer.toUpperCase();
            
            //Switch statement to loop through user menu choice
            switch(answer) {
                case "V" -> hotel.DisplayRooms(); //Call each method on the hotel object
                case "A" -> hotel.AddCustomer();
                case "E" -> hotel.DisplayEmptyRooms();
                case "D" -> hotel.DeleteCustomer();
                case "F" -> hotel.FindRoom();
                case "S" -> hotel.StoreData();
                case "L" -> hotel.LoadData();
                case "O" -> hotel.OrderAlphabetically();
                case "W" -> hotel.GetQueue();
                case "Q" -> loop = false; //If user opts to quit, loop is stopped
                default -> //Default case for if user input is not recognised 
                    System.out.println("Option not recognised. Please try again.");
            }
            
            
        }
    }
    
    
}
