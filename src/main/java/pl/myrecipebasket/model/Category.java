package pl.myrecipebasket.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="category_name", nullable=false, unique=true, length=45)
	private String category_name;
	@Column(name="category_type", nullable=false)
	private CategoryType caregory_type;
	@ManyToMany(mappedBy="categories", 
			cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Recipe> recipes = new ArrayList<>();
	
	public Category() {
		super();
	}
	
	public Category(Category category) {
		super();
		this.category_name = category.getCategory_name();
		this.caregory_type = category.getCaregory_type();
		this.recipes = category.getRecipes();
	}

	public Category(String category_name, CategoryType caregory_type, List<Recipe> recipes) {
		super();
		this.category_name = category_name;
		this.caregory_type = caregory_type;
		this.recipes = recipes;
	}


	public String getCategory_name() {
		return category_name;
	}

	public CategoryType getCaregory_type() {
		return caregory_type;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public void setCaregory_type(CategoryType caregory_type) {
		this.caregory_type = caregory_type;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	@Override
	public String toString() {
		return "Category [category_name=" + category_name + ", caregory_type=" + caregory_type + ", number of recipes=" + recipes.size()
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caregory_type == null) ? 0 : caregory_type.hashCode());
		result = prime * result + ((category_name == null) ? 0 : category_name.hashCode());
		result = prime * result + ((recipes == null) ? 0 : recipes.hashCode());
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
		Category other = (Category) obj;
		if (caregory_type != other.caregory_type)
			return false;
		if (category_name == null) {
			if (other.category_name != null)
				return false;
		} else if (!category_name.equals(other.category_name))
			return false;
		if (recipes == null) {
			if (other.recipes != null)
				return false;
		} else if (!recipes.equals(other.recipes))
			return false;
		return true;
	}
	
	
	
}
