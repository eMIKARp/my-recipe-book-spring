package pl.myrecipebasket.repository;

import java.util.List;
import java.util.Locale.Category;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
}
