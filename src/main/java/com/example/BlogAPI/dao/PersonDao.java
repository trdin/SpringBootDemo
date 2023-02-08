package com.example.BlogAPI.dao;

import com.example.BlogAPI.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.UUID;

public interface PersonDao {
    int  insertPerson(UUID id, Person person);

    default Person insertPerson(Person person){
        UUID id = UUID.randomUUID();
        if(insertPerson(id, person) == 1){
            return new Person(id, person.getName());
        }else{
            return null;
        }
    }

    List<Person> selectAllPeople();

    int deletePerson(UUID id);

    int updatePerson(UUID id, Person person);

    Optional<Person> selectPersonById(UUID id);

}
