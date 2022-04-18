package davidkecskes.stateproject.repository;

import davidkecskes.stateproject.model.BidOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidOwnerRepository extends JpaRepository<BidOwner, Long> {
}
