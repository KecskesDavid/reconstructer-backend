package davidkecskes.stateproject.repository;

import davidkecskes.stateproject.dto.bid.BidResponseDTO;
import davidkecskes.stateproject.model.Bids;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidRepository extends JpaRepository<Bids, Long> {
}
