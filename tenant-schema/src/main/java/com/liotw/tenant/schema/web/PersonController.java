package com.liotw.tenant.schema.web;

import com.liotw.tenant.schema.domain.Person;
import com.liotw.tenant.schema.dto.PersonDto;
import com.liotw.tenant.schema.repository.PersonRepository;
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
    public Person save(@RequestBody PersonDto personDto){
        return  personRepository.save(personDto.createPerson());
    }

    @GetMapping
    private List<Person> all(){
        return personRepository.findAll();
    }
}
