package com.example.Bankmangement.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bankmangement.entity.Role;
import com.example.bankmangement.repository.RoleRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testFindByName() {
        Optional<Role> role = roleRepository.findByName("USER");
        assertTrue(role.isPresent());
        assertEquals("USER", role.get().getName());
    }
}
