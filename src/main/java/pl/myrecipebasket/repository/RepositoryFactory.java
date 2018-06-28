package pl.myrecipebasket.repository;

import pl.myspringboothibernateapp.exceptions.NoSuchDbTypeException;

public abstract class RepositoryFactory {

 	public static final int MYSQL_REPO_FACTORY = 1;
	 
    public abstract UserRepository getUserRepository();
    public abstract RecipeRepository getRecipeRepository();
    public abstract VoteRepository getVoteRepository();
    public abstract CategoryRepository getCategoryRepository();
    
    public static RepositoryFactory getRepositoryFactory() {
    	RepositoryFactory factory = null;
    		try {
				factory.getRepositoryFactory(MYSQL_REPO_FACTORY);
			} catch (NoSuchDbTypeException e) {
				e.printStackTrace();
			}
    	return factory;
    }
    
    public static RepositoryFactory getRepositoryFactory(int type) throws NoSuchDbTypeException {
    	
    	switch(type) {
	    	case MYSQL_REPO_FACTORY:
	    		return new MySqlRepositoryFactory();
	    	default:
	    		throw new NoSuchDbTypeException(); 
    	}
    }
    
    
	    
}
