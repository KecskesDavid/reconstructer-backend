package davidkecskes.stateproject.repository;

import davidkecskes.stateproject.model.Markets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketRepository extends JpaRepository<Markets, Long> {

    @Query(value = "SELECT * FROM markets WHERE user_id = ?1", nativeQuery = true)
    List<Markets> findByUserId(String userId);
}
