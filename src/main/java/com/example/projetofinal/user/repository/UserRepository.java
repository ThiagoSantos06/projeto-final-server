package com.example.projetofinal.user.repository;

import com.example.projetofinal.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {



}
