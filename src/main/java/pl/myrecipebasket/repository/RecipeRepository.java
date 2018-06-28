package pl.myrecipebasket.repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.myrecipebasket.model.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>{

	public List<Recipe> findAllByUsername(String username);
	public List<Recipe> findAllByCategory_name(String category_name);
	public List<Recipe> findAllByIs_sharedTrue();
	@Query(name="Recipe.shareRecipe")
	public void shareRecipe(@Param("recipe_id")Long recipe_id);
}
