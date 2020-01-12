package kg.UserRoleInTokenTest.repository;

import kg.UserRoleInTokenTest.entity.Premise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremiseRepository extends JpaRepository<Premise, Long> {
}
