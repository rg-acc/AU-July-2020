package com.au2020;

import com.au2020.BlockingQueue;

public class Consumer extends Thread {

	private final BlockingQueue queue;
	
	public Consumer(BlockingQueue queue, String name) {
	
		super(name);
		this.queue = queue;
	}

	@Override
	public void run() {
	
		while (true) {
	
			synchronized (queue) {
	
				try{
	
					Object consumed = queue.take();
					System.out.println("Consumer thread " + Thread.currentThread().getName() + " consumed item:" + consumed.toString());
					queue.notifyAll();
				} 
				catch (Exception e) {
					System.out.println(e);
				}
	
			}
		}
	
	}
}
