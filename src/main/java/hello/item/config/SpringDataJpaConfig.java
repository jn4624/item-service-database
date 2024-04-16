package hello.item.config;

import hello.item.repository.ItemRepository;
import hello.item.repository.jpa.JpaItemRepositoryV2;
import hello.item.repository.jpa.SpringDataJpaItemRepository;
import hello.item.service.ItemService;
import hello.item.service.ItemServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SpringDataJpaConfig {
    private final SpringDataJpaItemRepository springDataJpaItemRepository;

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new JpaItemRepositoryV2(springDataJpaItemRepository);
    }
}
