package pl.myrecipebasket.repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.myrecipebasket.model.Recipe;
import pl.myrecipebasket.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findAllByUsername(String username);
	@Query(name="User.findAllFavourite")
	public List<Recipe> findAllFavouriteRecipes(@Param("username")String username);
	@Query(name="User.checkIfRecipeIsInFavourite")	
	public Recipe checkIfRecipeIsInFavourite(@Param("recipe_id")Long recipe_id); 	
	@Query(name="User.deleteFromFavourite")
	public void deleteFromFavourite(@Param("username") String username,@Param("recipe_id") Long recipe_id); 
}

