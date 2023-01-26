package com.example.Bankmangement.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bankmangement.entity.User;
import com.example.bankmangement.repository.UserRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUsername() {
        Optional<User> user = userRepository.findByUsername("johnDoe");
        assertTrue(user.isPresent());
        assertEquals("johnDoe", user.get().getUsername());
    }

    @Test
    public void testExistsByUsername() {
        boolean exists = userRepository.existsByUsername("johnDoe");
        assertTrue(exists);
    }

    @Test
    public void testFindById() {
        User user = userRepository.findById(1L);
        assertEquals("johnDoe", user.getUsername());
    }
}
