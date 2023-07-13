package com.liotw.tenant.database.web;

import com.liotw.tenant.database.domain.Person;
import com.liotw.tenant.database.dto.PersonDto;
import com.liotw.tenant.database.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Person Controller
 *
 * @author jjl
 * @date 2023/7/12
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public Person save(@RequestBody PersonDto personDto) {
        return personRepository.save(personDto.createPerson());
    }

    @GetMapping
    private List<Person> all() {
        return personRepository.findAll();
    }
}
