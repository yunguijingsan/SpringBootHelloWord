package cn.lcf.core.spring;

import java.io.IOException;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

public class CustomJsonHttpMessageConverter extends MappingJackson2HttpMessageConverter{

	@Override
	protected void writeInternal(Object obj, HttpOutputMessage httpOutputMessage)
			throws IOException, HttpMessageNotWritableException {
		super.writeInternal(obj, httpOutputMessage);
	}



}
