package by.testv2.core.entity;

import jakarta.persistence.*;

@Entity
@Table(schema = "app", name = "sky")
public class SkyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String color;
    private boolean available;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    public SkyEntity() {
    }

    public SkyEntity(Long id,
                     String name,
                     String description,
                     String color,
                     boolean available,
                     ProductEntity productEntity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.color = color;
        this.available = available;
        this.productEntity = productEntity;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public ProductEntity getProduct() {
        return productEntity;
    }

    public void setProduct(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}