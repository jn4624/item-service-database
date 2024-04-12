package hello.item.config;

import hello.item.repository.ItemRepository;
import hello.item.repository.memory.MemoryItemRepository;
import hello.item.service.ItemService;
import hello.item.service.ItemServiceV1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemoryConfig {
    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new MemoryItemRepository();
    }
}
