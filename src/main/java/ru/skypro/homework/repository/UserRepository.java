package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.model.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
   //Optional<User> findByEmail(String name);
    @Query(value = "SELECT * from users where username= :name", nativeQuery = true)
    Optional<User> findByUsername(String name);
/*    @Query(value = "SELECT * from User", nativeQuery = true)
    Optional<User> findByName(String name);*/
}
