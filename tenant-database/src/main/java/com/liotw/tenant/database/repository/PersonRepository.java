package com.liotw.tenant.database.repository;

import com.liotw.tenant.database.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Person Repository
 *
 * @author jjl
 * @date 2023/7/12
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByName(String name);
}
