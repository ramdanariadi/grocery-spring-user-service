package tunas.grocery.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductRepository.CustomSelect> getAll(){
        return productRepository.findTableColumn();
    }

    public Product findProductById(UUID id){
        return productRepository.findProductById(id);
    }

    public void saveProduct(Product product){
        productRepository.save(product);
    }
}
