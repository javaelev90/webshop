package se.webshop.restserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.webshop.restserver.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {
}
