package ru.itmo.coursework4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ru.itmo.coursework4.entities.Alpinist;
import ru.itmo.coursework4.entities.Group;
import ru.itmo.coursework4.entities.Mountain;
import ru.itmo.coursework4.validation.EntityValidator;

import java.time.LocalDateTime;

public class Application {
    public static void main(String[] args) {
        try (EntityManagerFactory factory = Persistence.createEntityManagerFactory("coursework4");
             EntityManager manager = factory.createEntityManager()) {

            EntityValidator entityValidator = new EntityValidator();

            Alpinist serj = new Alpinist();
            serj.setName("Serj");
            serj.setAddress("Kolpino");
            serj.setAge(29);
            entityValidator.validate(serj);

            Alpinist dimas = new Alpinist();
            dimas.setName("Dimas");
            dimas.setAddress("Saint-P");
            dimas.setAge(30);
            entityValidator.validate(dimas);

            Mountain everest = new Mountain();
            everest.setName("Everest");
            everest.setCountry("China");
            everest.setHeight(8848);
            entityValidator.validate(everest);

            Mountain elbrus = new Mountain();
            elbrus.setName("Elbrus");
            elbrus.setCountry("Russia");
            elbrus.setHeight(5642);
            entityValidator.validate(elbrus);

            Group group1 = new Group();
            group1.setMaxSize(5);
            group1.setAscensionTime(LocalDateTime.parse("2023-05-20T18:00"));
            group1.getAlpinists().add(serj);
            group1.getAlpinists().add(dimas);
            group1.setMountain(everest);
            entityValidator.validate(group1);

            Group group2 = new Group();
            group2.setMaxSize(5);
            group2.setAscensionTime(LocalDateTime.parse("2023-08-20T18:00"));
            group2.getAlpinists().add(serj);
            group2.getAlpinists().add(dimas);
            group2.setMountain(elbrus);
            entityValidator.validate(group2);

            manager.getTransaction().begin();
            manager.persist(serj);
            manager.persist(dimas);
            manager.persist(group1);
            manager.persist(group2);
            manager.persist(everest);
            manager.persist(elbrus);
            manager.getTransaction().commit();

            manager.getTransaction().begin();
            manager.remove(everest);
            manager.getTransaction().commit();
        }
    }
}
