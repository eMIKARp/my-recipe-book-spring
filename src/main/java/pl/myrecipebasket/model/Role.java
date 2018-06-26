package pl.myrecipebasket.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="role_type", nullable=false, unique=true, length=45)
	private RoleType role_type;
	@OneToMany(mappedBy="role")
	private List<User> users = new ArrayList<>();
	
	public Role() {
		super();
	}
	
	public Role(Role role) {
		super();
		this.role_type = role.getRole_type();
		this.users = role.getUsers();
	}

	public Role(RoleType role_type, List<User> users) {
		super();
		this.role_type = role_type;
		this.users = users;
	}

	public RoleType getRole_type() {
		return role_type;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setRole_type(RoleType role_type) {
		this.role_type = role_type;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [role_type=" + role_type + ", users=" + users + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role_type == null) ? 0 : role_type.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (role_type != other.role_type)
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}
	
	
}
