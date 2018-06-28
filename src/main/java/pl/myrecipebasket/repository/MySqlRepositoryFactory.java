package pl.myrecipebasket.repository;

import pl.myrecipebasket.MyRecipeBasketAppApplication;

public class MySqlRepositoryFactory extends RepositoryFactory {

	@Override
	public UserRepository getUserRepository() {
		return MyRecipeBasketAppApplication.ctx.getBean(UserRepository.class);
	}
	@Override
	public RecipeRepository getRecipeRepository() {
		return MyRecipeBasketAppApplication.ctx.getBean(RecipeRepository.class);
	}
	@Override
	public VoteRepository getVoteRepository() {
		return MyRecipeBasketAppApplication.ctx.getBean(VoteRepository.class);
	}
	@Override
	public CategoryRepository getCategoryRepository() {
		return MyRecipeBasketAppApplication.ctx.getBean(CategoryRepository.class);
	}
	
}
