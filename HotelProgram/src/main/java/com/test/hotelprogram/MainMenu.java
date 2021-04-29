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
public class MainMenu {
    
    public MainMenu() {
        
    }
    public void displayMenu() {
        System.out.println("\n\n---WELCOME TO MY HOTEL---");
        System.out.println("V : View all rooms");
        System.out.println("A : Add customer");
        System.out.println("E : Display empty rooms");
        System.out.println("D : Delete customer from room");
        System.out.println("F : Find room from customer name");
        System.out.println("S : Store program data into file");
        System.out.println("L : Load program data from file");
        System.out.println("O : View guests ordered aphabetically by name");
        System.out.println("W: Display waiting queue.");
        System.out.println("Press Q to exit.");
    }
}
