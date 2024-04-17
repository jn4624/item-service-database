package hello.item.config;

import hello.item.repository.ItemRepository;
import hello.item.repository.jpa.JpaItemRepositoryV3;
import hello.item.service.ItemService;
import hello.item.service.ItemServiceV1;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class QuerydslConfig {
    private final EntityManager entityManager;

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new JpaItemRepositoryV3(entityManager);
    }
}
