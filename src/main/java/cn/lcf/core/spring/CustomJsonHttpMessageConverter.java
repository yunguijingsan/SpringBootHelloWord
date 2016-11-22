package cn.lcf.core.spring;

import java.io.IOException;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

import cn.lcf.core.exception.ResponseResult;

@Component
public class CustomJsonHttpMessageConverter extends
		MappingJackson2HttpMessageConverter {

	
	@Override
	protected void writeInternal(Object obj, HttpOutputMessage httpOutputMessage)
			throws IOException, HttpMessageNotWritableException {
		if(obj instanceof ResponseResult){
			ResponseResult<?> responseResult = (ResponseResult<?>) obj;
			this.writeResponseResult(responseResult);
		}else{
			super.writeInternal(obj, httpOutputMessage);
		}
	
	}

	private void writeResponseResult(ResponseResult<?> responseResult) {

	   
	}

}
