package cn.lcf.ims.service;

public interface BaseService<T> {
	T findById(Integer id);
	
	void add(T t);
	
	void update(T t);
	
	void delete(T t);
}
