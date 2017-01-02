package cn.lcf.core.exception;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class Result<T> {
	public Class<T> getGenericType() {
		Type type = getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			return (Class<T>) ((TypeVariable)((ParameterizedType) type).getActualTypeArguments()[0]).getGenericDeclaration();
		} else {
			return (Class<T>) Object.class;
		}
	}
}
