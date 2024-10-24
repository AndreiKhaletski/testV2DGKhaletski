package by.testv2.core.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "app", name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private boolean active;
    private LocalDate start_date;

    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SkyEntity> skuses = new ArrayList<>();


    public ProductEntity() {
    }

    public ProductEntity(Long id,
                         String name,
                         String description,
                         boolean active,
                         LocalDate start_date,
                         List<SkyEntity> skuses) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.active = active;
        this.start_date = start_date;
        this.skuses = skuses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public List<SkyEntity> getSkuses() {
        return skuses;
    }

    public void setSkuses(List<SkyEntity> skuses) {
        this.skuses = skuses;
    }
}