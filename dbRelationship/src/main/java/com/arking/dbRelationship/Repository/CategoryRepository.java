package com.arking.dbRelationship.Repository;

import com.arking.dbRelationship.Entity.Product.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
