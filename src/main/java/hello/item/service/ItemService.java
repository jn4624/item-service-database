package hello.item.service;

import hello.item.domain.Item;
import hello.item.repository.ItemSearchCond;
import hello.item.repository.ItemUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    Item save(Item item);

    void update(Long itemId, ItemUpdateDto updateParam);

    Optional<Item> findById(Long id);

    List<Item> findItems(ItemSearchCond itemSearch);
}
