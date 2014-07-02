package com.self.filter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.self.util.JSONUtil;

@Provider
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EntityFilter implements MessageBodyWriter<Object>,MessageBodyReader<Object> {

	  private static final String UTF_8 = "UTF-8";
	  
	  private volatile Gson gson;
	 
	  private Gson getGson() {
	    if (gson == null) {
	      final GsonBuilder gsonBuilder = JSONUtil.getGsonBuilder();
	      gson = gsonBuilder.create();
	    }
	    return gson;
	  }
	 
	  @Override
	  public boolean isReadable(Class<?> type, Type genericType,java.lang.annotation.Annotation[] annotations, MediaType mediaType) {
	    return true;
	  }
	 
	  @Override
	  public Object readFrom(Class<Object> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException {
	    InputStreamReader streamReader = new InputStreamReader(entityStream, UTF_8);
	    Object			  returnValue  = null;
	    try {
	      Type jsonType;
	      if (type.equals(genericType)) {
	        jsonType = type;
	      } else {
	        jsonType = genericType;
	      }
	      returnValue = getGson().fromJson(streamReader, jsonType);
	    } finally {
	      streamReader.close();
	    }
	    return returnValue;
	  }
	 
	  @Override
	  public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
	    return true;
	  }
	 
	  @Override
	  public long getSize(Object object, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
	    return -1;
	  }
	 
	  @Override
	  public void writeTo(Object object, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
	    OutputStreamWriter writer = new OutputStreamWriter(entityStream, UTF_8);
	    try {
	      Type jsonType;
	      if (type.equals(genericType)) {
	        jsonType = type;
	      } else {
	        jsonType = genericType;
	      }
	      if(!object.getClass().isAssignableFrom(Exception.class)){
	    	  getGson().toJson(object, jsonType, writer);
	      }else{
	    	  writer.write(object.toString());
	      }
	    } finally {
	      writer.close();
	    }
	  }

}
