package com.self;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;

import com.self.entity.Beer;
import com.self.entity.QueueMessage;
import com.self.filter.EntityFilter;

public class ClientConnector {

	public ClientConnector(){
		
	}
	
	private final Client client = buildClient();

	private Client buildClient() {
		return ClientBuilder.newClient(new ClientConfig().register(EntityFilter.class)
				.property(ClientProperties.CONNECT_TIMEOUT, 2000)
				.property(ClientProperties.READ_TIMEOUT,    5000));
	}
	public final int send(int index, QueueMessage entity){
		WebTarget webtarget = client.target("http://lx-dev-cit-05:9200/queuemessage/queue/"+index);
		Entity<QueueMessage> modEntity = Entity.entity(entity, MediaType.APPLICATION_JSON);
		
		Response resp = webtarget.request().put(modEntity);
		return resp.getStatus();
	}
	public final int delete(int index){
		WebTarget webtarget = client.target("http://lx-dev-cit-05:9200/queuemessage/queue/"+index);

		Response resp = webtarget.request().delete();
		return resp.getStatus();
	}
}
