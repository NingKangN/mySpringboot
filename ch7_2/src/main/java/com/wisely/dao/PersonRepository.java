package com.wisely.dao;

import com.wisely.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,String> {
    List<Person> findByName(String name);
}
