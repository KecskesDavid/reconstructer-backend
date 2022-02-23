package davidkecskes.stateproject.repository;

import davidkecskes.stateproject.model.Authorizations;
import davidkecskes.stateproject.model.AuthorizationsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizationRepository extends JpaRepository<Authorizations, AuthorizationsId> {
}
