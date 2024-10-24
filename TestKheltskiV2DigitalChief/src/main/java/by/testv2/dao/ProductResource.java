package by.testv2.dao;

import by.testv2.core.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductResource extends JpaRepository<ProductEntity, Long> {
}
