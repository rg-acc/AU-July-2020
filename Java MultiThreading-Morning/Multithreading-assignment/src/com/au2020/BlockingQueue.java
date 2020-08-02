package com.au2020;

import java.util.*; 

public class BlockingQueue { 
	  
    private List queue = new LinkedList(); 
    private int size = 7; 
  
    public BlockingQueue(int size) 
    { 
        this.size = size; 
    } 
  
    public synchronized void put(Object item) 
        throws Exception 
    { 
        while (this.queue.size() == this.size) { 
            wait();
            throw new Exception("Queue is full. No task is already taken by any of the consumer."); 
        } 
        if (this.queue.size() == 0) { 
            notifyAll(); 
        } 
        this.queue.add(item); 
    } 
  
    public synchronized Object take() 
        throws Exception 
    { 	
        while (this.queue.size() == 0) { 
        	wait(); 
        	throw new Exception("Queue is empty. There is no task present in the Queue.");
        	
        } 
        if (this.queue.size() == this.size) { 
            notifyAll(); 
        } 
  
        return this.queue.remove(0); 
    } 
} 