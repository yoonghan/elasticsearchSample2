package com.self.util;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import com.self.entity.QueueMessage;

//make random messages
public class RandomQueueMessage {
	
	private final int TIME_GAP = 1000 *60 * 60;
	private static final class Singleton{
		private static final RandomQueueMessage instance = new RandomQueueMessage();
	}
	
	public static RandomQueueMessage getInstance(){
		return Singleton.instance;
	}
	
	private Random rand = new Random();
	private final String[] userId = new String[]{"Alex","Bob","Carris","Denver","Edward", "Francis","Gaga"};
	private final int MAX_USERID=userId.length;
	
	private final String[] header = new String[]{
		"{\"originIp\":\"127.0.0.1\"}",
		"{\"originIp\":\"127.0.0.2\"}",
		"{\"originIp\":\"127.0.0.3\"}",
		"{\"originIp\":\"127.0.0.4\"}",
		"{\"originIp\":\"127.0.0.5\"}",
		"{\"originIp\":\"127.0.0.6\"}",
		"{\"originIp\":\"127.0.0.7\"}",
		"{\"originIp\":\"127.0.0.8\"}",
		"{\"originIp\":\"127.0.0.9\"}"
	};
	private final int MAX_HEADER = header.length;
	
	private final String[] body = new String[]{
		"\"mtId\":1000,\"message\":\"teste1\",\"priority\":1,\"expireDate\":\"01/05/2014 15:33:00,559\",\"sendTime\":\"28/04/2014 15:33:00,658\",\"retries\":5}",
		"\"mtId\":2000,\"message\":\"teste2\",\"priority\":2,\"expireDate\":\"02/05/2014 15:33:00,559\",\"sendTime\":\"28/04/2014 15:33:00,658\",\"retries\":5}",
		"\"mtId\":3000,\"message\":\"teste3\",\"priority\":3,\"expireDate\":\"03/05/2014 15:33:00,559\",\"sendTime\":\"28/04/2014 15:33:00,658\",\"retries\":5}",
		"\"mtId\":4000,\"message\":\"teste4\",\"priority\":4,\"expireDate\":\"04/05/2014 15:33:00,559\",\"sendTime\":\"28/04/2014 15:33:00,658\",\"retries\":5}",
		"\"mtId\":5000,\"message\":\"teste5\",\"priority\":5,\"expireDate\":\"05/05/2014 15:33:00,559\",\"sendTime\":\"28/04/2014 15:33:00,658\",\"retries\":5}",
	};
	private final int MAX_BODY = body.length;
	
	private Long getRandomId(){
		return new Long(rand.nextInt(100));
	}
	
	private Long getRandomServiceId(){
		return new Long(rand.nextInt(50));
	}
	
	private Long getRandomQueueId(){
		return Math.abs(rand.nextLong());
	}
	
	private Integer getRandomLeafId(){
		return Math.abs(rand.nextInt(4));
	}
	
	private Date getRandomDate(){
		long time = new Date().getTime();
		return new Date(rand.nextInt(TIME_GAP)+time);
	}
	
	private Long getRandomDeliveryDate(){
		return new Long(rand.nextInt(100));
	}
	
	private String getRandomUserId(){
		return userId[rand.nextInt(MAX_USERID-1)];
	}
	
	private Long getClusterId(){
		return new Long(rand.nextInt(5));
	}
	
	private Long getRandomTargetId(){
		return new Long(rand.nextInt(5));
	}
	
	private Integer getReasonId(){
		return rand.nextInt(50);
	}
	
	private String getRandomHeader(){
		return header[rand.nextInt(MAX_HEADER-1)];
	}
	
	private String getRandomBody(){
		return body[rand.nextInt(MAX_BODY-1)];
	}
	
	public QueueMessage getMessage(long id){
		
		Date generatedDate = getRandomDate();
		
		QueueMessage qm = new QueueMessage();
		qm.setId(id);
		qm.setUuid(UUID.randomUUID().toString());
		qm.setMessageDefId(getRandomId());
		qm.setServiceId(getRandomServiceId());
		qm.setOperatorId(1);
		qm.setQueueId(getRandomQueueId());
		qm.setUserIdentifier(getRandomUserId());
		qm.setUserIdentifier(getRandomUserId());
		qm.setClusterNodeId(getClusterId());
		qm.setLeafId(getRandomLeafId());
		qm.setRetriesCount(5);
		qm.setDeliveryDate(new Date(generatedDate.getTime()+getRandomDeliveryDate()));
		qm.setCreationDate(generatedDate);
		qm.setModificationDate(generatedDate);
		qm.setExpireDate(generatedDate);
		qm.setTargetId(getRandomTargetId());
		qm.setPriority(3);
		qm.setFetchStatusId(2);
		qm.setStatusReasonId(getReasonId());
		qm.setStatusId(getReasonId());
		qm.setHeader(getRandomHeader());
		qm.setBody(getRandomBody());
		return qm;
	}
}
