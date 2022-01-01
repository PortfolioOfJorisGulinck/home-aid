package be.jorisgulinck.homeaid;

import be.jorisgulinck.homeaid.product.ProductController;
import be.jorisgulinck.homeaid.setup.StarterData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "be.jorisgulinck.homeaid")
public class HomeAidApplication {

	Logger logger = LoggerFactory.getLogger(HomeAidApplication.class);

	@PersistenceUnit
	private EntityManagerFactory emf;

	public static void main(String[] args) {
		SpringApplication.run(HomeAidApplication.class, args);
	}

	@PostConstruct
	public void start() {
		EntityManager entityManager = emf.createEntityManager();
		StarterData starterData = new StarterData();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			starterData.fillDatabase(entityManager);
			transaction.commit();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			entityManager.close();
		}
	}

}
