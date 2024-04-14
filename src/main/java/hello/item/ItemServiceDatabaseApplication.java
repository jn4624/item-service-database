package hello.item;

import hello.item.config.JdbcTemplateV1Config;
import hello.item.config.JdbcTemplateV2Config;
import hello.item.config.MemoryConfig;
import hello.item.repository.ItemRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

//@Import(MemoryConfig.class)
//@Import(JdbcTemplateV1Config.class)
@Import(JdbcTemplateV2Config.class)
@SpringBootApplication(scanBasePackages = "hello.item.web")
public class ItemServiceDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceDatabaseApplication.class, args);
	}

	@Bean
	@Profile("local")
	public TestDataInit testDataInit(ItemRepository itemRepository) {
		return new TestDataInit(itemRepository);
	}

}
