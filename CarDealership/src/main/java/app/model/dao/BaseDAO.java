package app.model.dao;
import java.util.Set;

public interface BaseDAO<T>{
	boolean create(T type);
	T read(int id);
	boolean update(T type);
	boolean delete(int id);
	Set<T> readAll();
}