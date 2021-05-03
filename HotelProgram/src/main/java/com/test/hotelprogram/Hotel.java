/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.hotelprogram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author shona
 */
public class Hotel {
    
    private static Scanner input = new Scanner(System.in);
    
    private Room[] rooms;
    private int roomsBooked;
    private Queue queue;
    private MainMenu menu;
    private FormatValidation validUserInput;
    
    //Hotel constructor to build hotel
    public Hotel() {
        menu = new MainMenu();
        roomsBooked = 0;
        rooms = new Room[8]; initialise();
        queue = new Queue();
        validUserInput = new FormatValidation();
    }

    public void GetMenu() {
        menu.displayMenu();
    }
    
    public void GetQueue() {
        queue.displayQueue();
    }
    
    //Method used to add customer
    public void AddCustomer() {
        Room room; 
        //Selection statement to check hotel isn't full
        try 
        {
            if(roomsBooked != 8) 
            {
                System.out.println("What room would you like to book (1-8): ");
                int roomNum = (input.nextInt()-1);
                input.nextLine();
                if(rooms[roomNum].getStatus() == false)
                {
                    room = GetCustomerInfo();
                    rooms[roomNum] = room;
                    roomsBooked++;
                } else 
                {
                    //Let the user know if the room is booked to try again 
                    System.out.println("This room is booked. Please try again.");
                }
            } else 
            {
                //If hotel is full, check if there is space in the queue by calling isFull() method from Queue class
                if(!queue.isFull()) 
                {
                    System.out.println("Hotel is booked - please join waiting list.");
                    room = GetCustomerInfo();
                    //Add the customer to the end of the waiting list
                    queue.addQueue(room);
                } else 
                {
                    System.out.println("Hotel and queue are full. Please come back.");
                }
            }
        } catch (Exception e)
        {
            System.out.println("Error: " + e);
            System.out.println("Please try again.");
        }
    }
    
    
    //Method to display all rooms at the users request
    public void DisplayRooms() {
        System.out.printf("%-5s %-15s %-10s %-10s", "ROOM", "NAME", "GUESTS", "CONTACT");
        System.out.println("\n----------------------------------------");
        for(int i = 0; i < rooms.length; i++)
        {
            if(rooms[i].getStatus() == false)
            {
                System.out.printf("%-5d %-15s %-10s %-10s", (i+1), "EMPTY", " ", " ");
                System.out.print("\n");
            } else
            {
                System.out.printf("%-5d %-15s %-10d %-10s", (i+1), rooms[i].getName(), rooms[i].GetGuestsNo(), rooms[i].getPhoneNumber());
                System.out.print("\n");
            }        
        }
        System.out.println("\nNumber of rooms booked: " + roomsBooked);


    }
    
    
    //Method to display all empty rooms
    public void DisplayEmptyRooms() {
        if(roomsBooked == 8) 
        {
            System.out.println("No empty rooms.");
        } else 
        {
            //Loop to loop through array of room objects
            for(int i = 0; i < rooms.length; i++)
            {
                //Check to see if room is empty or not
                if(rooms[i].getStatus() == false) 
                {
                    //Print if room is empty
                    System.out.println("Room " + (i+1) + " is empty.");
                }
            }
        }
    }
    
    //Method to delete customer from room
    public void DeleteCustomer() {
        int roomNum; 
        System.out.println("Which room would you like to delete (1-8): ");
        roomNum = input.nextInt();
        input.nextLine(); //Advance the scanner to the next line (clears the buffer so ready for the next input)
        
        //Check valid room number is entered (between 1 and 8)
        if(roomNum < 0 || roomNum > 9) 
        {
            System.out.println("Please choose a valid room number.");
            
        } else if (rooms[roomNum - 1].getStatus() == false)
        {
            System.out.println("Room is already empty. Try again.");
        } else
        {
            if(!queue.isEmpty())
            {
                Room room = queue.TakeQueue();
                System.out.println("Customer " + room.getName() + " is now in room: " + roomNum);
                rooms[roomNum-1] = room;
            } else 
            {
                rooms[roomNum-1] = new Room();
                roomsBooked--;
            }
        }
        
    }
    
    public void FindRoom() {
        //Initialise room number for validation
        int roomNum = - 1;
        System.out.println("Enter the first name: ");
        String firstName = input.nextLine();
        System.out.println("Enter the last name: ");
        String lastName = input.nextLine();
        String fullName = (firstName + " " + lastName).toLowerCase(); //Set to lower case 
        
        for(int i = 0; i < rooms.length; i++) //Loop through each room in array
        {
            if(rooms[i].getStatus() == true) //If occupied, check if name of room matches name entered 
            {
               if(((rooms[i].getName().toLowerCase()).equals(fullName))) 
                {
                    roomNum = i; //Set roomNum to the iterator
                } 
            }
        }
        
        if( roomNum == -1 ) //IF roomNum still -1, customer has not been found
        {
            
            System.out.println("Customer cannot be found");
        } else 
        {
            System.out.println("Customer " + fullName + " is in room: " + (roomNum + 1 ));
        }
    }
    
    //Method to store data in external text file
    public void StoreData() { 
        try //Excpetion statement to catch error
        {
            //Use BufferedWriter class to open HotelData text file
            BufferedWriter writer = new BufferedWriter(new FileWriter("HotelData.txt"));
            StoreArray(rooms, writer);
            writer.write("QUEUE");   
        } catch (IOException e) 
        {
            System.out.println("Sorry an error occured: " + e); 
        }
    }
    
    public void StoreArray(Room[] array, BufferedWriter writer) {
        String lineSpace = " ";
        try {
            for (Room room : array) 
                {
                    //If room is occupied, store user information in file
                    if (room.getStatus() == true)
                    {
                        writer.write(room.getName());
                        writer.write(lineSpace);
                        writer.write(room.getCardNum());
                        writer.write(lineSpace);
                        writer.write(Integer.toString(room.GetGuestsNo()));
                        writer.write(lineSpace);
                        writer.write(room.getPhoneNumber());
                        writer.newLine();
                    } else 
                    {
                        //Else write an empty line to indicate no customer
                        writer.write("");
                        writer.newLine();
                    }
                    writer.flush();
                }
            writer.close();
        } catch (IOException e)
        {
            System.out.println("Error: " + e);        
        }
    }  
    
    //Method to load data from external text file
    public void LoadData() {
        try 
        {
            //Initialise rooms booked back to 0
            roomsBooked = 0;
            String[] data = new String[4];
            //Use BufferedReader class to read external text file
            try (BufferedReader reader = new BufferedReader(new FileReader("HotelData.txt"))) 
            {
                //Loop through each line of file
                for(Room room: rooms)
                {
                    String currentLine = reader.readLine();
                    
                    //If line is empty, set room to empty
                    if("".equals(currentLine)) 
                    {
                        room = new Room();
                    } else 
                    {    
                        //Else split the data into an array
                        data = currentLine.split(" ");
                        String fname = data[0];
                        String lname = data[1];
                        String cardNum = data[2];
                        String phoneNumber = data[3];
                            
                        //Change guestNo value from String to integer
                        int guestNo = Integer.parseInt(data[3]);
                        Person customer; //Initialise new person
                        customer = new Person(fname, lname, cardNum, phoneNumber); //Create person with customer information
                        room = new Room(customer, guestNo); //Store the person in a room
                        roomsBooked++; //Increment roomsBooked by 1
                        reader.close();
                    }  
                }
            }        
        } catch(IOException e) //Catch error thrown
        { 
            System.out.println("An error occured: " + e);
        }
    }
    
    public void OrderAlphabetically() {
        String temp;
        //Initialise new arrayList to store names in alphabetical order
        ArrayList<String> orderedNames = new ArrayList<>();
        
        //Loop through each room
        for(Room room: rooms) 
        {
            //If room is occupied, store name in orderedNames
            if(room.getStatus() == true)
            {
                orderedNames.add((room.getName().toLowerCase()));
            }       
        }

        //Nested for loop
        for(int i = 0; i < orderedNames.size(); i++)
        {
            for(int j = i + 1; j < orderedNames.size(); j++)
            {
                //Compare each value to each other
                if(orderedNames.get(i).compareTo(orderedNames.get(j)) > 0) 
                {
                    //Use external ArrayList methods to get indexes (i,j) from orderedNames
                    temp = orderedNames.get(i);
                    orderedNames.set(i, orderedNames.get(j));
                    orderedNames.set(j, temp);
                }
            }
        }
        
        System.out.println("\nNames in alphabetical order: ");
        
        //Print new array to user
        orderedNames.forEach(orderedName -> {
            System.out.println(orderedName);
        });   
    }
    
    public void EmptyHotelandQueue() {
        roomsBooked = 0; 
        initialise();
        queue.initialise();
        StoreData();
        System.out.println("Hotel and Queue are emptied.");
    }
    
    //External method to get customer information in the AddCustomer() method 
    public Room GetCustomerInfo() {
        boolean valid;
        String fname, lname, phoneNumber, cardNum;
        do 
        {
            System.out.println("**IF INPUT IS INVALID, YOU WILL BE ASKED TO RE ENTER ALL INFORMATION**");
            System.out.println("First name:");
            fname = (input.nextLine()).trim(); //Trim data so no errors when storing in external file
            System.out.println("Last name: ");
            lname = (input.nextLine()).trim();
            System.out.println("What is your phone number (MUST be 11 digits): ");
            phoneNumber = (input.nextLine()).trim();
            System.out.println("What is your credit card number (MUST be 16 digit): ");
            cardNum = (input.nextLine()).trim();
            valid = validUserInput.validateUserInfo(phoneNumber, cardNum, fname, lname);
        } while(!valid);

        System.out.println("Number of guests:");
        try 
        {
            int guestNo = input.nextInt();
            input.nextLine();
            //Create a person object
            Person customer = new Person(fname, lname, cardNum, phoneNumber);
            Room room = new Room(customer, guestNo);
            //Return the customer
            return room;
        } catch (Exception e)
        {
            System.out.println("Error: " + e);
            System.out.println("Please try again.");
            return new Room();
        }
    }
 
    public void CloseScanner() {
        input.close();
    }
    
    private void initialise() {
        for(Room room: rooms)
        {
            room = new Room();
        }
    }
    
    
}
