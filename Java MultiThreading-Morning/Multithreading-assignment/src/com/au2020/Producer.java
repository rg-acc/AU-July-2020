package com.au2020;

import java.util.*;

public class Producer extends Thread {

	private final BlockingQueue queue;
	
	public Producer(BlockingQueue queue, String name) {
		
		super(name);
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			
			synchronized (queue) {
	
				try{
	
					Random random = new Random();
					Integer i = random.nextInt();
					System.out.println("Producer producing value :" + i);
					
					queue.put(i);
					queue.notifyAll();

				} 
				catch (Exception e) {
					System.out.println(e);
				}
	
			}
		}
	}	
		
}
