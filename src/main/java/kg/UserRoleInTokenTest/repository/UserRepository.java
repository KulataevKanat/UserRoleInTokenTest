package kg.UserRoleInTokenTest.repository;

import kg.UserRoleInTokenTest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE lower(u.username) LIKE coalesce(lower(cast(CONCAT('%',:username,'%') as text)),lower(u.username)) ")
    Optional<User> findByUsername(@Param("username") String username);
}
