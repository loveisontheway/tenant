package com.liotw.tenant.partition.dto;

import com.liotw.tenant.partition.domain.Person;
import lombok.Data;
import lombok.Value;

/**
 * Person Dto
 *
 * @author jjl
 * @date 2023/7/12
 */
@Data
public class PersonDto {

    private String name;
    private Integer age;

    public Person createPerson() {
        Person person = new Person();
        person.setName(this.name);
        person.setAge(this.age);
        return person;
    }
}
