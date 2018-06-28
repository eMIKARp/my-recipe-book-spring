package pl.myrecipebasket.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pl.myrecipebasket.model.Recipe;
import pl.myrecipebasket.model.User;

@Repository
@Transactional
public class UserDaoImpl extends UserDao{

	public List<User> findAllUsers(){
		TypedQuery<User> query = entityManager.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}
	
	public User findUserByUsername(String username) {
		TypedQuery<User> query = entityManager.createNamedQuery("User.findByUsername", User.class);
		query.setParameter("username", username);
		return query.getSingleResult();
	}
	
	public void deleteAllUsers() {
		TypedQuery<User> query = entityManager.createNamedQuery("User.deleteAll", User.class);
		query.executeUpdate();
	}
	
	public List<Recipe> findAllFavouriteRecipes(String username){
		TypedQuery<Recipe> query = entityManager.createNamedQuery("User.findAllFavouriteByUsername", Recipe.class);
		query.setParameter("username", username);
		return query.getResultList();
	}
	
	public Boolean checkIfRecipeIsInFavourite(Long recipe_id) {
		TypedQuery<Recipe> query = entityManager.createNamedQuery("User.checkIfRecipeIsInFavourite", Recipe.class);
		query.setParameter("recipe_id", recipe_id);
		if (query.getSingleResult()!=null) {
			return true;
		} else return false;
	}
	
	public void deleteFromFavourite(String username, Long recipe_id) {
		TypedQuery<Recipe> query = entityManager.createNamedQuery("User.deleteFromFavourite", Recipe.class);
		query.setParameter("username", username);
		query.setParameter("recipe_id", recipe_id);
		query.executeUpdate();
	}
}

