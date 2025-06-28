package org.gfg.Spring_Minor.repository;


import org.gfg.Spring_Minor.enums.UserType;
import org.gfg.Spring_Minor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    User findByEmailAndUserType(String email, UserType userType);
}