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
    
    /**
     * Class constructor to initialise each of the class variables.
     */
    public Queue() 
    {
        this.SIZE = 8;
        this.top = 0;
        this.end = 0;
        this.currentSize = 0;
        QueueArray = new Room[8]; //QueueArray has 8 rooms
        initialise(); //Initialise the QueueArray to empty rooms
    }
    
    /**
     * This method adds a new room to end of the queue if the queue is not full.
     * @param newRoom New room.
     */
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
    
    /**
     * This method is used to take the object from the front of the queue 
     * Is called in the DeleteCustomer() method when a customer is deleted from the rooms array.
     * @return Room to be stored in rooms array.
     */
    public Room TakeQueue()
    {
        Room room = QueueArray[top];
        top = (top + 1) % SIZE;
        //Take 1 from current size
        currentSize --;
        //Return the queue taken from the front of the queue
        return room;
    }
    
    /**
     * This method is used to check whether the QueueArray is full
     * Used when a new object is trying to be added into the queue.
     * @return true or false.
     */
    public boolean isFull() {
        //Returns true if queue is full
        return top == ((end + 1) % SIZE);  
    }
    
    /**
     * THis method is used to check whether the QueueArray is empty
     * Used when an object is trying to be removed.
     * @return true or false.
     */
    public boolean isEmpty() 
    {
        //Returns true if queue is empty
        return top == end;
    }
    
    /**
     * This method is used when the user wants to display the contents of the QueueArray.
     */ 
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
    
    /**
     * Used to initialise the QueueArray to 8 empty rooms.
     */
    public void initialise() 
    {
        for(Room queueValue : QueueArray) 
        {
            queueValue = new Room();
        }
    }
}
