import com.au2020.BlockingQueue;
import com.au2020.Producer;
import com.au2020.Consumer;


public class Main {

	public static void main(String[] args) {

		final BlockingQueue buffer = new BlockingQueue(10);

		Producer producer = new Producer(buffer,"Producer");

		Consumer consumer1 = new Consumer(buffer,"Consumer 1");
		Consumer consumer2 = new Consumer(buffer,"Consumer 2");
		Consumer consumer3 = new Consumer(buffer,"Consumer 3");
		
		System.out.println("Main thread");
		consumer1.start();
		producer.start();
		consumer2.start();
		consumer3.start();
		
	}
}	
	
	
