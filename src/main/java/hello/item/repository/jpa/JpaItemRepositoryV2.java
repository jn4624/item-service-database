package hello.item.repository.jpa;

import hello.item.domain.Item;
import hello.item.repository.ItemRepository;
import hello.item.repository.ItemSearchCond;
import hello.item.repository.ItemUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class JpaItemRepositoryV2 implements ItemRepository {
    private final SpringDataJpaItemRepository jpaRepository;

    @Override
    public Item save(Item item) {
        return jpaRepository.save(item);
    }

    @Override
    public void update(Long itemId, ItemUpdateDto updateParam) {
        Item findItem = jpaRepository.findById(itemId).orElseThrow();
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    @Override
    public Optional<Item> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<Item> findAll(ItemSearchCond cond) {
        String itemName = cond.getItemName();
        Integer maxPrice = cond.getMaxPrice();

        if (StringUtils.hasText(itemName) && maxPrice != null) {
            return jpaRepository.findItems("%"+ itemName +"%", maxPrice);
        } else if (StringUtils.hasText(itemName)) {
            return jpaRepository.findByItemNameLike("%"+ itemName +"%");
        } else if (maxPrice != null) {
            return jpaRepository.findByPriceLessThanEqual(maxPrice);
        } else {
            return jpaRepository.findAll();
        }
    }
}
