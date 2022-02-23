package davidkecskes.stateproject.repository;

import davidkecskes.stateproject.model.MarketTypes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketTypeRepository extends CrudRepository<MarketTypes, Integer> {
}
