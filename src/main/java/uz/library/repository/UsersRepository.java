package uz.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.library.model.Users;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByIdAndIsActive(Integer id, Short isActive);

    Optional<Users> findByEmailAndIsActive(String email, Short isActive);
}
