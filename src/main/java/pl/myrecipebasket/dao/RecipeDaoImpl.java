package pl.myrecipebasket.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pl.myrecipebasket.model.Recipe;

@Repository
@Transactional
public class RecipeDaoImpl extends RecipeDao{

	public List<Recipe> getAllRecipes(){
		TypedQuery<Recipe> query = entityManager.createNamedQuery("Recipe.findAll", Recipe.class);
		return query.getResultList();
	}
	
	public void deleteAllRecipes() {
		TypedQuery<Recipe> query = entityManager.createNamedQuery("Recipe.deleteAll", Recipe.class);
		query.executeUpdate();
	}
	
	public List<Recipe> getAllRecipesByUsername(String username) {
		TypedQuery<Recipe> query = entityManager.createNamedQuery("Recipe.findAllByUsername", Recipe.class);
		query.setParameter("username", username);
		return query.getResultList();
	}
	
	public List<Recipe> getAllRecipesByCategory(String category_name) {
		TypedQuery<Recipe> query = entityManager.createNamedQuery("Recipe.findAllByCategory", Recipe.class);
		query.setParameter("category_name", category_name);
		return query.getResultList();
	}
	
	public List<Recipe> getAllSharedRecipes(){
		TypedQuery<Recipe> query = entityManager.createNamedQuery("Recipe.findAllShared", Recipe.class);
		return query.getResultList();
	}
	
	public void shareRecipe(Long recipe_id){
		TypedQuery<Recipe> query = entityManager.createNamedQuery("Recipe.shareRecipe", Recipe.class);
		query.executeUpdate();
	}
}
