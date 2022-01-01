package be.jorisgulinck.homeaid.product;

import be.jorisgulinck.homeaid.shared.services.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService implements CrudService<Product> {

    private final ProductDAO productDAO;

    @Override
    public Product save(Product product) {
        productDAO.save(product);
        return product;
    }

    @Override
    public Product getById(long id) {
        return productDAO.getById(id);
    }

    @Override
    public List<Product> getAll() {
        return productDAO.findAll();
    }

    @Override
    public void delete(long id) {
        productDAO.delete(getById(id));
    }
}
