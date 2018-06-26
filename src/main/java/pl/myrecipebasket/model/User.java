package pl.myrecipebasket.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user", length=11)
	private Long id;
	@Column(name="username", nullable=false, unique=true, length=45)
	private String username;
	@Column(name="email", nullable=false, unique=true, length=60)
	private String email;
	@Column(name="password", nullable=false, length=45)
	private String password;
	@Column(name="is_active", nullable=false)
	private Boolean is_active;
	
	@ManyToMany
	@JoinTable(name="favourite_recipes",
	joinColumns= {@JoinColumn(name="user_id", referencedColumnName="id_user")},
	inverseJoinColumns= {@JoinColumn(name="recipe_id", referencedColumnName="id_recipe")}
	)
	private List<Recipe> favRecipes = new ArrayList<>();
	
	@OneToMany(mappedBy="user")
	private List<Recipe> ownRecipes = new ArrayList<>();
	
	@OneToMany(mappedBy="user")
	private List<Vote> votes = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="role")
	private Role role;

	public User() {
		super();
	}
	
	public User(User user) {
		super();
		this.id = user.getId();
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.is_active = user.getIs_active();
		this.favRecipes = user.getFavRecipes();
		this.ownRecipes = user.getOwnRecipes();
		this.votes = user.getVotes();
		this.role = user.getRole();
	}
	
	public User(Long id, String username, String email, String password, Boolean is_active, List<Recipe> favRecipes,
			List<Recipe> ownRecipes, List<Vote> votes, Role role) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.is_active = is_active;
		this.favRecipes = favRecipes;
		this.ownRecipes = ownRecipes;
		this.votes = votes;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public List<Recipe> getFavRecipes() {
		return favRecipes;
	}

	public List<Recipe> getOwnRecipes() {
		return ownRecipes;
	}

	public List<Vote> getVotes() {
		return votes;
	}

	public Role getRole() {
		return role;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	public void setFavRecipes(List<Recipe> favRecipes) {
		this.favRecipes = favRecipes;
	}

	public void setOwnRecipes(List<Recipe> ownRecipes) {
		this.ownRecipes = ownRecipes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", is_active=" + is_active + ", favRecipes=" + favRecipes + ", ownRecipes=" + ownRecipes + ", votes="
				+ votes + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((favRecipes == null) ? 0 : favRecipes.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((is_active == null) ? 0 : is_active.hashCode());
		result = prime * result + ((ownRecipes == null) ? 0 : ownRecipes.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((votes == null) ? 0 : votes.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (favRecipes == null) {
			if (other.favRecipes != null)
				return false;
		} else if (!favRecipes.equals(other.favRecipes))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (is_active == null) {
			if (other.is_active != null)
				return false;
		} else if (!is_active.equals(other.is_active))
			return false;
		if (ownRecipes == null) {
			if (other.ownRecipes != null)
				return false;
		} else if (!ownRecipes.equals(other.ownRecipes))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (votes == null) {
			if (other.votes != null)
				return false;
		} else if (!votes.equals(other.votes))
			return false;
		return true;
	}
	
}
