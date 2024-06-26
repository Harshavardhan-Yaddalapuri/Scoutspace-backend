package com.scoutspace.Accommodation.repository;

import com.scoutspace.Accommodation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByUserId(Long userId);

    Optional<User> deleteUserByUserId(Long userId);

    Optional<User> deleteUserByEmail(String email);
}
