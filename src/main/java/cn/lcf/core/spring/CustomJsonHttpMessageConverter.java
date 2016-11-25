package cn.lcf.core.spring;

import java.io.IOException;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

import cn.lcf.core.exception.ResponseResult;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.json.JsonGeneratorImpl;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JsonParserSequence;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.util.JSONPObject;

@Component
public class CustomJsonHttpMessageConverter extends
		MappingJackson2HttpMessageConverter {

	
	@Override
	protected void writeInternal(Object obj, HttpOutputMessage httpOutputMessage)
			throws IOException, HttpMessageNotWritableException {
		if(obj instanceof ResponseResult){
			ResponseResult<?> responseResult = (ResponseResult<?>) obj;
			this.writeResponseResult(responseResult,httpOutputMessage);
		}else{
			super.writeInternal(obj, httpOutputMessage);
		}
		ObjectMapper objectMapper = super.getObjectMapper();
		objectMapper.getPropertyNamingStrategy()
		
	}

	private void writeResponseResult(ResponseResult<?> responseResult,HttpOutputMessage httpOutputMessage) {
		try {
			super.writeInternal(responseResult, httpOutputMessage);
		} catch (HttpMessageNotWritableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}

}
