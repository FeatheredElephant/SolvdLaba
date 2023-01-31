package app.model.mappers;

import java.util.List;

import org.apache.ibatis.annotations.*;

import app.model.domains.User;

@Mapper
public interface UserMapper extends BaseMapper<User>{
	@Select("SELECT * FROM person")
	@Results(value = {
			@Result(property = "id", column = "person_id"),
			@Result(property="name", column = "name")
	})
	List<User> readAll();
	
	@Insert("INSERT INTO person(person_id, name) VALUES(#{id}, #{name})")
	boolean create(User user);
	
	@Select("SELECT * FROM person WHERE person_id=#{id}")
	@Results(value = {
			@Result(property = "id", column = "person_id"),
			@Result(property="name", column = "name")
	})
	User read(int id);
	
	@Update("UPDATE person SET name=#{name} WHERE person_id=#{id})")
	boolean update(User user);
	
	@Delete("DELETE FROM person WHERE person_id=#{id}")
	boolean delete(int id);
}