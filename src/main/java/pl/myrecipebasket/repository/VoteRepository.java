package pl.myrecipebasket.repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.myrecipebasket.model.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long>{
	
	public Vote findAllByUsernameAndRecipe_id(@Param("username")String username, @Param("recipe_id") Long recipe_id);
}
