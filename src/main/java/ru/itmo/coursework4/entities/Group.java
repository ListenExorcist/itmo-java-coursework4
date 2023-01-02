package ru.itmo.coursework4.entities;

import jakarta.persistence.*;

import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    private List<Alpinist> alpinists = new ArrayList<>();

    @ManyToOne(optional = false)
    private Mountain mountain;

    @Column(name = "is_recruiting", nullable = false)
    private boolean isRecruiting = true;

    @Column(name = "max_size", nullable = false)
    @Min(1)
    private int maxSize;

    @Column(name = "ascension_time", nullable = false)
    private LocalDateTime ascensionTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Alpinist> getAlpinists() {
        return alpinists;
    }

    public void setAlpinists(List<Alpinist> alpinists) {
        this.alpinists = alpinists;
    }

    public Mountain getMountain() {
        return mountain;
    }

    public void setMountain(Mountain mountain) {
        this.mountain = mountain;
    }

    public boolean isRecruiting() {
        return isRecruiting;
    }

    public void setRecruiting(boolean recruiting) {
        isRecruiting = recruiting;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public LocalDateTime getAscensionTime() {
        return ascensionTime;
    }

    public void setAscensionTime(LocalDateTime ascensionTime) {
        this.ascensionTime = ascensionTime;
    }
}
