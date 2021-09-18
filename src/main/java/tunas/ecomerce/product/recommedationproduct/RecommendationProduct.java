package tunas.ecomerce.product.recommedationproduct;

import tunas.ecomerce.product.Product;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "recommendationProducts")
public class RecommendationProduct {
    @Id
    @Column(name = "product_id")
    UUID id;
    Long price;
    String name;
    Integer perUnit; // gram
    String description;
    Integer weight; // on gram
    String imageUrl;
    @Column(columnDefinition = "boolean default false")
    Boolean deleted = false;

    @OneToOne
    @MapsId
    @JoinColumn(name = "product_id")
    Product product;

    public RecommendationProduct() {
    }

    public RecommendationProduct(Product product){
        this.setName(product.getName());
        this.setPrice(product.getPrice());
        this.setDescription(product.getDescription());
        this.setPerUnit(product.getPerUnit());
        this.setWeight(product.getWeight());
        this.setImageUrl(product.getImageUrl());
        this.setProduct(product);
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPerUnit() {
        return perUnit;
    }

    public void setPerUnit(Integer perUnit) {
        this.perUnit = perUnit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
