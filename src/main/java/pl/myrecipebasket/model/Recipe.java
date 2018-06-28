package pl.myrecipebasket.model;

import pl.myrecipebasket.model.Category;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name="Recipe.findAll", query="SELECT r FROM Recipe r"),
	@NamedQuery(name="Recipe.deleteAll", query="DELETE FROM Recipe r"),
	@NamedQuery(name="Recipe.findAllByUsername", query="SELECT r FROM Recipe r WHERE r.user.username=:username"),
	@NamedQuery(name="Recipe.findAllByCategory", query="SELECT r FROM Recipe r WHERE r.categories.category_name=:category_name"),
	@NamedQuery(name="Recipe.findAllShared", query="SELECT r FROM Recipe r WHERE r.is_shared=true"),
	@NamedQuery(name="Recipe.shareRecipe", query="UPDATE Recipe r SET r.is_shared = true WHERE r.id=:recipe_id")
})
@Table(name="recipe")
public class Recipe implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_recipe", length=11)
	private Long id;
	@Column(name="name", nullable=false, length=100)
	private String name;
	@Column(name="description", nullable=false, length=5000)
	private String description;
	@Column(name="url", nullable=false, unique=true, length=200)
	private String url;
	@Column(name="date", nullable=false)
	private Timestamp date;
	@Column(name="up_vote", nullable=false)
	private int up_vote;
	@Column(name="down_vote", nullable=false)
	private int down_vote;
	@Column(name="is_shared", nullable=false)
	private Boolean is_shared;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToMany(mappedBy="favRecipes", 
			cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
	private List<User> usrWhoAddRecipeToFav = new ArrayList<>();
	
	@ManyToMany (cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinTable(name="recipe_category",
	joinColumns= {@JoinColumn(name="recipe_id", referencedColumnName="id_recipe")},
	inverseJoinColumns= {@JoinColumn(name="category_name", referencedColumnName="category_name")}
	)
	private List<Category> categories= new ArrayList<>();
	
	@OneToMany(mappedBy="recipe",
			cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Vote> votes = new ArrayList<>();

	public Recipe() {
		super();
	}
	
	public Recipe(Recipe recipe) {
		super();
		this.id = recipe.getId();
		this.name = recipe.getName();
		this.description = recipe.getDescription();
		this.url = recipe.getUrl();
		this.date = recipe.getDate();
		this.up_vote = recipe.getUp_vote();
		this.down_vote = recipe.getDown_vote();
		this.is_shared = recipe.getIs_shared();
		this.user = recipe.getUser();
		this.usrWhoAddRecipeToFav = recipe.getUsrWhoAddRecipeToFav();
		this.categories = recipe.getCategories();
		this.votes = recipe.getVotes();
	}
	
	public Recipe(Long id, String name, String description, String url, Timestamp date, int up_vote, int down_vote,
			Boolean is_shared, User user, List<User> usrWhoAddRecipeToFav, List<Category> categories,
			List<Vote> votes) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.url = url;
		this.date = date;
		this.up_vote = up_vote;
		this.down_vote = down_vote;
		this.is_shared = is_shared;
		this.user = user;
		this.usrWhoAddRecipeToFav = usrWhoAddRecipeToFav;
		this.categories = categories;
		this.votes = votes;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getUrl() {
		return url;
	}

	public Timestamp getDate() {
		return date;
	}

	public int getUp_vote() {
		return up_vote;
	}

	public int getDown_vote() {
		return down_vote;
	}

	public Boolean getIs_shared() {
		return is_shared;
	}

	public User getUser() {
		return user;
	}

	public List<User> getUsrWhoAddRecipeToFav() {
		return usrWhoAddRecipeToFav;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public List<Vote> getVotes() {
		return votes;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public void setUp_vote(int up_vote) {
		this.up_vote = up_vote;
	}

	public void setDown_vote(int down_vote) {
		this.down_vote = down_vote;
	}

	public void setIs_shared(Boolean is_shared) {
		this.is_shared = is_shared;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUsrWhoAddRecipeToFav(List<User> usrWhoAddRecipeToFav) {
		this.usrWhoAddRecipeToFav = usrWhoAddRecipeToFav;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", description=" + description + ", url=" + url + ", date="
				+ date + ", up_vote=" + up_vote + ", down_vote=" + down_vote + ", is_shared=" + is_shared + ", who added="
				+ user.getUsername() + ", number of users who added recipy to fav=" + usrWhoAddRecipeToFav.size() + ", categories=" + categories + ", votes="
				+ votes + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + down_vote;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((is_shared == null) ? 0 : is_shared.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + up_vote;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((usrWhoAddRecipeToFav == null) ? 0 : usrWhoAddRecipeToFav.hashCode());
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
		Recipe other = (Recipe) obj;
		if (categories == null) {
			if (other.categories != null)
				return false;
		} else if (!categories.equals(other.categories))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (down_vote != other.down_vote)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (is_shared == null) {
			if (other.is_shared != null)
				return false;
		} else if (!is_shared.equals(other.is_shared))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (up_vote != other.up_vote)
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (usrWhoAddRecipeToFav == null) {
			if (other.usrWhoAddRecipeToFav != null)
				return false;
		} else if (!usrWhoAddRecipeToFav.equals(other.usrWhoAddRecipeToFav))
			return false;
		if (votes == null) {
			if (other.votes != null)
				return false;
		} else if (!votes.equals(other.votes))
			return false;
		return true;
	}
	
	
}
