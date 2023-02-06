package com.example.BlogAPI.service;

import com.example.BlogAPI.dao.PersonDao;
import com.example.BlogAPI.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }

    public int deletePerson(UUID id ){
        return personDao.deletePerson(id);
    }

    public int updatePerson(UUID id, Person newPerson){
        return personDao.updatePerson(id, newPerson);
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }
}
