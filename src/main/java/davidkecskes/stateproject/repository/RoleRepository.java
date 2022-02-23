package davidkecskes.stateproject.repository;

import davidkecskes.stateproject.model.Roles;
import davidkecskes.stateproject.model.VAuthorizationsIdUtil;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Roles, Integer> {

    @Query(value = "select id from roles where name='user';", nativeQuery = true)
    int getUserRoleId();

    @Query(value = "select id from roles where name='data_owner';", nativeQuery = true)
    int getDataOwnerRoleId();

    @Query(value = "select id from roles where name='administrator';", nativeQuery = true)
    int getAdminRoleId();

    @Query(value = "select nextval('seq_roles');", nativeQuery = true)
    int getNextValue();

    @Query(value = "select role_id as RoleId, role_name as RoleName, user_id as UserId, user_name as UserName from v_authorizations;", nativeQuery = true)
    List<VAuthorizationsIdUtil> getAllAuthorizations();

}
