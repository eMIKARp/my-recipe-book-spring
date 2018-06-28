package pl.myrecipebasket.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pl.myrecipebasket.model.Vote;

@Repository
@Transactional
public class VoteDaoImpl extends VoteDao{
	
	public List<Vote> getAllVotes(){
		TypedQuery<Vote> query = entityManager.createNamedQuery("Vote.findAll", Vote.class);
		return query.getResultList();
	}
	
	public void removeAllVotes() {
		TypedQuery<Vote> query = entityManager.createNamedQuery("Vote.deleteAll", Vote.class);
		query.executeUpdate();
	}
	
	public Vote getVoteByUsernameAndRecipeId(String username, Long recipe_id) {
		TypedQuery<Vote> query = entityManager.createNamedQuery("Vote.getVoteByUserIdAndRecipeId", Vote.class);
		query.setParameter("username", username);
		query.setParameter("recipe_id", recipe_id);
		
		return query.getSingleResult();
	}
	
}
