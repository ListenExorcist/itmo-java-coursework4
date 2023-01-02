package ru.itmo.coursework4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ru.itmo.coursework4.entities.Alpinist;
import ru.itmo.coursework4.entities.Group;
import ru.itmo.coursework4.entities.Mountain;

import java.time.LocalDateTime;

public class Application {
    public static void main(String[] args) {
        try (EntityManagerFactory factory = Persistence.createEntityManagerFactory("coursework4");
             EntityManager manager = factory.createEntityManager()) {

            Alpinist serj = new Alpinist();
            serj.setName("S");
            serj.setAddress("Kolpino");
            serj.setAge(29);

            Alpinist dimas = new Alpinist();
            dimas.setName("Dimas");
            dimas.setAddress("SPB");
            dimas.setAge(30);

            Mountain everest = new Mountain();
            everest.setName("Everest");
            everest.setCountry("China");
            everest.setHeight(8848);

            Mountain elbrus = new Mountain();
            elbrus.setName("Elbrus");
            elbrus.setCountry("Russia");
            elbrus.setHeight(5642);

            Group group1 = new Group();
            group1.setMaxSize(0);
            group1.setAscensionTime(LocalDateTime.parse("2023-05-20T18:00"));
            group1.getAlpinists().add(serj);
            group1.getAlpinists().add(dimas);
            group1.setMountain(everest);

            Group group2 = new Group();
            group2.setMaxSize(5);
            group2.setAscensionTime(LocalDateTime.parse("2023-08-20T18:00"));
            group2.getAlpinists().add(serj);
            group2.getAlpinists().add(dimas);
            group2.setMountain(elbrus);

            manager.getTransaction().begin();
            manager.persist(serj);
            manager.persist(dimas);
            manager.persist(group1);
            manager.persist(group2);
            manager.persist(everest);
            manager.persist(elbrus);
            manager.getTransaction().commit();

            manager.getTransaction().begin();
//            manager.remove(everest);
            manager.getTransaction().commit();
        }
    }
}
