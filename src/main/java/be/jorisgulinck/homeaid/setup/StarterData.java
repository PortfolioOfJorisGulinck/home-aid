package be.jorisgulinck.homeaid.setup;

import be.jorisgulinck.homeaid.product.Product;
import be.jorisgulinck.homeaid.shared.Packaging;
import be.jorisgulinck.homeaid.shared.Volume;
import be.jorisgulinck.homeaid.user.User;

import javax.persistence.EntityManager;

public class StarterData {

    public void fillDatabase(EntityManager entityManager) {

        // Users
        User user = new User(1, "user", "user", true, "USER");

        // Products
        Product product1 = new Product(1, "Choco", "Chocoladepasta", Packaging.BOWL, Volume.GRAM);

        // Saving to the database
        entityManager.persist(user);

    }
}
