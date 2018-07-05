package se.webshop.restserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import se.webshop.restserver.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByroleType(Role.RoleType roleType);
}
