package app.model.domains;

import java.util.Objects;

import javax.xml.bind.annotation.XmlElement;

public class User {

	private Integer id;

	private String name;

	public User(Integer id, String name) {
		setId(id);
		setName(name);
	}

	public User() {
		
	}

	public int getId() {
		return id;
	}

	@XmlElement(name = "userId")
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@XmlElement(name = "name")
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
}
