package davidkecskes.stateproject.repository;

import davidkecskes.stateproject.model.BidStatuses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BidStatusRepository extends JpaRepository<BidStatuses, Long> {

    @Query(value = "SELECT id FROM bid_statuses AS b WHERE b.name='FINISHED';", nativeQuery = true)
    Long getHistoryStatusId();
}
