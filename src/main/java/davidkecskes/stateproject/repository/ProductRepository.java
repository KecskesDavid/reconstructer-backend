package davidkecskes.stateproject.repository;

import davidkecskes.stateproject.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {

    @Query(value = "select nextval('seq_products');", nativeQuery = true)
    int getNextValue();

}
