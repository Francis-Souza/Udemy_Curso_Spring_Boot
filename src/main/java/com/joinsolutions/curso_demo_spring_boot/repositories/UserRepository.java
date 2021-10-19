package com.joinsolutions.curso_demo_spring_boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.joinsolutions.curso_demo_spring_boot.entities.User;



public interface UserRepository extends JpaRepository<User, Long> {	


}
