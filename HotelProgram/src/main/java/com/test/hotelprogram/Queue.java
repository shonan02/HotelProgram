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
public class Queue {
    
    private Room[] QueueArray;
    private final int SIZE;
    private int top, end, currentSize;
    
    //Queue class constructor 
    public Queue() 
    {
        //Set each variable to its initial value
        this.SIZE = 8;
        this.top = 0;
        this.end = 0;
        this.currentSize = 0;
        QueueArray = new Room[8];

        //Initialise the QueueArray to empty rooms
        initialise();
    }
    
    public void addQueue(Room newRoom) 
    { //Add queue method with newRoom parameter 
        //Add the parameter to the end of the queue
        QueueArray[end] = newRoom;
        //Change the value of the end of the queue
        end = (end + 1) % SIZE;
        //Add one to current size
        currentSize++;
        System.out.println(newRoom.getName() + " has been added to the queue.");
    }
    
    public Room TakeQueue()
    {
        Room room = QueueArray[top];
        top = (top + 1) % SIZE;
        //Take 1 from current size
        currentSize --;
        //Return the queue taken from the front of the queue
        return room;
    }
    
    public boolean isFull() {
        //Returns true if queue is full
        return top == ((end + 1) % SIZE);  
    }
    
    public boolean isEmpty() 
    {
        //Returns true if queue is empty
        return top == end;
    }
    
    //Method to display the values in the queue 
    public void displayQueue() 
    {
        if(!isEmpty()) 
        {
            System.out.println("Waiting queue: ");
            
            //For loop that loops from front to end
            for(int i = top; i != end; i = (i + 1) % SIZE ) 
            {
                //Outputs the names of the rooms in the queue
                System.out.println(QueueArray[i].getName());
            }
            
            System.out.println("Queue items: " + currentSize);             
        } else 
        {
            //If queue is empty, print this statement
            System.out.println("Queue is empty.");
        }
    }
    
    //Private method to initialise the queue to empty rooms
    public void initialise() 
    {
        for(Room queueValue : QueueArray) 
        {
            queueValue = new Room();
        }
    }
}
