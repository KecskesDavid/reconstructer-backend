package davidkecskes.stateproject.repository;

import davidkecskes.stateproject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {

    Users findByEmail(String email);

    @Query(value = "select nextval('seq_users');", nativeQuery = true)
    int getNextValue();

}
