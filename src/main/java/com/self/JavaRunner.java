package com.self;


import com.self.entity.QueueMessage;
import com.self.util.RandomQueueMessage;

public class JavaRunner {

	public static void main(String[] args) {
		
		int start = 0;
		
		if(args.length == 0){
			System.err.println("Invalid usage, supply 1 INTEGER argument");
			System.exit(-1);
		}
		
		try{
			start = Integer.parseInt(args[0],10);	
		}catch(Exception e){
			System.err.println("Invalid usage, supply 1 INTEGER argument");
			System.exit(-1);
		}
		
		System.out.println("--Start--");
		
		ClientConnector client = new ClientConnector();
		
		final int START = start;
		final int MAX_LOOP=500+START; 
		final long SLEEP_TIMER = 100;
		
		for(int i=START; i < MAX_LOOP; i++){
			QueueMessage queueMessage = RandomQueueMessage.getInstance().getMessage(i);
			
			if(201 != client.send(i, queueMessage)){
				System.err.println("ERROR ON "+i);
				System.exit(-1);
			}
			
			try{
				System.out.println("Inserted:-"+i);
				Thread.sleep(SLEEP_TIMER);
			}catch(Exception e){
				System.out.println("Fail:-"+i);
				e.printStackTrace();
			}
			
		}
	}

}
