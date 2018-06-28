package pl.myrecipebasket.dao;

import java.util.List;
import java.util.Locale.Category;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CategoryDaoImpl extends CategoryDao{

	public List<Category> getAllCategories(){
		TypedQuery<Category> query = entityManager.createNamedQuery("Category.findAll", Category.class);
		return query.getResultList();
	}
	public void deleteAllCategories(){
		TypedQuery<Category> query = entityManager.createNamedQuery("Category.deleteAll", Category.class);
		query.executeUpdate();
	}
}
