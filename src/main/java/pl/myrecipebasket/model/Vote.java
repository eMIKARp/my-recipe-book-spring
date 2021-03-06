package pl.myrecipebasket.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name="Vote.findAll", query="SELECT v FROM Vote v"),
	@NamedQuery(name="Vote.deleteAll", query="DELETE FROM Vote v"),
	@NamedQuery(name="Vote.getVoteByUserIdAndRecipeId", query="SELE	CT v FROM Vote v WHERE v.user.id=:user_id AND v.recipe.id=:recipe_id")
})
@Table(name="vote")
public class Vote implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name="recipe_id")
	private Recipe recipe;
	private Timestamp date;
	private VoteType voteType;
	
	public Vote() {
		super();
	}

	public Vote(Vote vote) {
		super();
		this.id=vote.getId();
		this.user = vote.getUser();
		this.recipe = vote.getRecipe();
		this.date = vote.getDate();
		this.voteType = vote.getVoteType();
	}
	
	public Vote(Long id, User user, Recipe recipe, Timestamp date, VoteType voteType) {
		super();
		this.id=id;
		this.user = user;
		this.recipe = recipe;
		this.date = date;
		this.voteType = voteType;
	}

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public Timestamp getDate() {
		return date;
	}

	public VoteType getVoteType() {
		return voteType;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public void setVoteType(VoteType voteType) {
		this.voteType = voteType;
	}

	@Override
	public String toString() {
		return "Vote [id=" + id + ", user=" + user + ", recipe=" + recipe + ", date=" + date + ", voteType=" + voteType
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((recipe == null) ? 0 : recipe.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((voteType == null) ? 0 : voteType.hashCode());
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
		Vote other = (Vote) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (recipe == null) {
			if (other.recipe != null)
				return false;
		} else if (!recipe.equals(other.recipe))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (voteType != other.voteType)
			return false;
		return true;
	}
	
	
}
