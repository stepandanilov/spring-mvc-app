package ru.danilov.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.danilov.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom", 24, "tom@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 34, "bob@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Mike", 18, "Mike@bbtw.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Katy", 54, "katy@gmail.com" ));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
    
    public void save(Person person) {
    	person.setId(++PEOPLE_COUNT);
    	people.add(person);
    }
    
    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
