package tunas.ecomerce.product.recommendationproduct;

import lombok.Data;
import lombok.NoArgsConstructor;
import tunas.ecomerce.product.Product;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "recommendationProducts")
@Data
@NoArgsConstructor
public class RecommendationProduct {
    @Id
    @Column(name = "product_id")
    UUID id;
    Long price;
    String name;
    String category;
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

    public RecommendationProduct(Product product){
        this.setName(product.getName());
        this.setPrice(product.getPrice());
        this.setDescription(product.getDescription());
        this.setPerUnit(product.getPerUnit());
        this.setWeight(product.getWeight());
        this.setImageUrl(product.getImageUrl());
        this.setCategory(product.getCategory().getCategory());
        this.setProduct(product);
    }
}
