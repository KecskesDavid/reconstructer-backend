package davidkecskes.stateproject;

import davidkecskes.stateproject.model.BidStatuses;
import davidkecskes.stateproject.model.ProductCategory;
import davidkecskes.stateproject.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StateprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(StateprojectApplication.class, args);
    }

    @Bean
    CommandLineRunner run(
            ProductCategoryRepository productCategoryRepository,
            BidStatusRepository bidStatusRepository
    ) {
        return args -> {
            /** Only for init */
            productCategoryRepository.save(new ProductCategory(0L, "Other"));
            productCategoryRepository.save(new ProductCategory(1L, "Tile"));
            productCategoryRepository.save(new ProductCategory(2L, "Cement"));
            productCategoryRepository.save(new ProductCategory(3L, "Paint"));
            productCategoryRepository.save(new ProductCategory(4L, "Something"));

//            bidStatusRepository.save(new BidStatuses(1L, "WAITING_FOR_OWNER"));
//            bidStatusRepository.save(new BidStatuses(2L, "WAITING_FOR_BUYER"));
//            bidStatusRepository.save(new BidStatuses(3L, "DECLINED"));
//            bidStatusRepository.save(new BidStatuses(4L, "FINISHED"));
        };
    }
}
