package id.newsservice.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "u_id")
	private long id;
	
	@Column(name = "u_username")
	private String username;
	
	@Column(name = "u_name")
	private String name;
	
	@Column(name = "u_password")
	private String password;
	
	@Column(name = "u_gender")
	private String gender;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public User() {
		
	}

	public User(String username, String name, String password, String gender) {
		super();
		this.username = username;
		this.name = name;
		this.password = password;
		this.gender = gender;
	}
	
}
