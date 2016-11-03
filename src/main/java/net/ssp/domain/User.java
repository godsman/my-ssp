package net.ssp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity 
public class User extends AbstractEntity {
	@Column(nullable=false, length=20, unique=true) // default true, 
	@JsonProperty
	private String userId;
	
	private String password;

	@JsonProperty
	private String name;

	@JsonProperty
	private String email;

	public boolean matchId(Long newId) {
		if (newId == null) {
			return false;
		}
		
		return newId.equals(getId());
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}

	public boolean matchPassword(String newPassword) {
		if (newPassword == null) {
			return false;
		}
		
		return newPassword.equals(password);
	}
	public String getPassword()
	{
		return password;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@Override
	public String toString()
	{
		return "User [" + super.toString() + ", password=" + password + ", name=" + name + ", email=" + email + "]";
	}

	public void update(User newUser)
	{
		// TODO Auto-generated method stub
		this.password = newUser.password;
		this.name = newUser.name;
		this.email = newUser.email;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		User other = (User) obj;
		if (getId() == null)
		{
			if (other.getId() != null) return false;
		}
		else if (!getId().equals(other.getId())) return false;
		return true;
	}
	
}
