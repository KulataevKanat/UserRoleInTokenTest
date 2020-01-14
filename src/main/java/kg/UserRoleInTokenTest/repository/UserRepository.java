package kg.UserRoleInTokenTest.repository;

import kg.UserRoleInTokenTest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * WORK WITH ODM
     */
    /*@Query("SELECT u FROM User u WHERE lower(u.username) LIKE coalesce(lower(cast(CONCAT('%',:username,'%') as text)),lower(u.username)) ")
    List<User> findByUsername(@Param("username") String username);*/


    /**
     * WORK WITH ORM
     */
    @Query("SELECT u FROM User u WHERE lower(u.username) LIKE coalesce(lower(cast(CONCAT('%',:username,'%') as text)),lower(u.username)) ")
    Optional<User> findByUsername(@Param("username") String username);
}
