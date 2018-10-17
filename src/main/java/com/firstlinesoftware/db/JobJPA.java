package com.firstlinesoftware.db;

import com.firstlinesoftware.entities.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

public interface JobJPA extends JpaRepository<User, Long> {
    <S extends User> List<S> findAll(Example<S> example);
}
