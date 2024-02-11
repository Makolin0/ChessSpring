package ChessSpring.repository;

import ChessSpring.model.DataBase.UserDB;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDB, Long> {
    Optional<UserDB> findByUsername(String username);

}
