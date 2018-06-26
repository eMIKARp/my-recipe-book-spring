package pl.myrecipebasket.dao;

import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public abstract class GenericDao<T,K> {

	@PersistenceContext
	private EntityManager entityManager;
	private Class<T> type;
	
	GenericDao() {
        type =(Class<T>)((ParameterizedType)this.getClass()
        		.getGenericSuperclass())
        		.getActualTypeArguments()[0];
    }
	
	public void save(T entity) {
		entityManager.persist(entity);
	}
	
	public void update(T entity) {
		entityManager.merge(entity);
	}
	
	public void remove(T entity) {
		T managedEntity = entityManager.merge(entity);
		entityManager.remove(managedEntity);
	}
	
	public T get(K key) {
		T entity = entityManager.find(type, key);
		return entity;
	}

}