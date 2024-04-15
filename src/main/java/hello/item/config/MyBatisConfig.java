package hello.item.config;

import hello.item.repository.ItemRepository;
import hello.item.repository.mybatis.ItemMapper;
import hello.item.repository.mybatis.MyBatisItemRepository;
import hello.item.service.ItemService;
import hello.item.service.ItemServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {
    private final ItemMapper itemMapper;

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new MyBatisItemRepository(itemMapper);
    }
}
