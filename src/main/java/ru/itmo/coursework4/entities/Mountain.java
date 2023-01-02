package ru.itmo.coursework4.entities;

import jakarta.persistence.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "tb_mountains")
public class Mountain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Size(min = 4)
    private String name;

    @Column(nullable = false)
    @Size(min = 4)
    private String country;

    @Column(nullable = false)
    @Min(100)
    private int height;

    @OneToMany(mappedBy = "mountain", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Group> groups;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
