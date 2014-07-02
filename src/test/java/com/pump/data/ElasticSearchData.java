package com.pump.data;

import com.self.entity.QueueMessage;
import com.self.util.FileCreator;
import com.self.util.JSONUtil;
import com.self.util.RandomQueueMessage;

public class ElasticSearchData {
	
	public static void main(String args[]){
		
		try{
			FileCreator fileCreator = new FileCreator("c://createAFile2.json");
			for(int i=0; i<50000; i++){
				fileCreator.writeFile(String.format("{\"index\":{\"_id\":\"%d\"}}\n", i));
				QueueMessage qmessage = RandomQueueMessage.getInstance().getMessage(i);
				fileCreator.writeFile(JSONUtil.toString(qmessage) + "\n");
				if(i % 500 == 0){
					try{
						Thread.sleep(1000);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
			fileCreator.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
