package ru.itmo.coursework4.entities;

import jakarta.persistence.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "tb_alpinists")
public class Alpinist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Size(min = 3)
    private String name;

    @Column(nullable = false)
    @Size(min = 5)
    private String address;

    @Column(nullable = false)
    @Min(18)
    private int age;

    @ManyToMany(mappedBy = "alpinists")
    private List<Group> groups;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
