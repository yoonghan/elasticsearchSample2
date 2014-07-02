package com.pump.data;


import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.self.ClientConnector;
import com.self.entity.QueueMessage;
import com.self.util.RandomQueueMessage;

public class DataPumper4 {

	@Test
	public void pumpData(){
		System.out.println("--Start--");
		
		ClientConnector client = new ClientConnector();
		
		final int START = 987;
		final int MAX_LOOP=500+START; 
		final long SLEEP_TIMER = 100;
		
		for(int i=START; i < MAX_LOOP; i++){
			QueueMessage queueMessage = RandomQueueMessage.getInstance().getMessage(i);
			
			Assert.assertEquals(201,client.send(i, queueMessage));
			
			try{
				System.out.println("Inserted:-"+i);
				Thread.sleep(SLEEP_TIMER);
			}catch(Exception e){
				System.out.println("Fail:-"+i);
				e.printStackTrace();
			}
			
		}
	}
	
	@Ignore
	@Test
	public void deleteData(){
		System.out.println("--Start--");
		
		ClientConnector client = new ClientConnector();
		
		final int MAX_LOOP=100; 
		
		for(int i=0; i < MAX_LOOP; i++){
			Assert.assertEquals(200,client.delete(i));	
			System.out.println("Deleted:"+i);
		}
	}
}
