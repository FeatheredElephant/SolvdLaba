package app.model.mappers;

import java.util.List;

import app.model.SessionPool;

public interface BaseMapper<T>{
	List<T> readAll();
	boolean create(T type);
	T read(int id);
	boolean update(T type);
	boolean delete(int id);
}