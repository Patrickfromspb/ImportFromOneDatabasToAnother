package com.company.db;

import com.company.entities.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobJPA extends JpaRepository<User, Long> {
    <S extends User> List<S> findAll(Example<S> example);
}
