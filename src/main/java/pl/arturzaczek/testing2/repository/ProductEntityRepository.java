package pl.arturzaczek.testing2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.arturzaczek.testing2.jpa.model.entity.ProductEntity;

import java.util.List;

public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {
    @Query("SELECT distinct p FROM ProductEntity p where p.isActive=true ")
    List<ProductEntity> getAllActiveProducts();

    @Query("SELECT distinct p FROM ProductEntity p where p.isActive=true and p.productName in (:serviceActivity)")
    List<ProductEntity> getAllActiveProductsMatchingToServiceActivity(List<String> serviceActivity);
}
