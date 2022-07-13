package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Item item = new Item("fender", 2300000, 1);

        //when
        Item saveItem = itemRepository.save(item);

        //then
        assertThat(saveItem).isEqualTo(itemRepository.findById(item.getId()));

    }

    @Test
    void findAll() {
        //given
        ArrayList<Item> bass = new ArrayList<Item>();
        Item fender = new Item("fender", 2300000, 1);
        Item musicMan = new Item("musicMan", 2000000, 1);
        Item sire = new Item("sire", 1000000, 1);
        Item yamaha = new Item("yamaha", 2100000, 1);
        bass.add(fender);
        bass.add(musicMan);
        bass.add(sire);
        bass.add(yamaha);

        for (Item item : bass) {
            Item savedBass = itemRepository.save(item);
            //assertThat(itemRepository.findById(item.getId())).isEqualTo(savedBass);
        }

        //when
        List<Item> basses = itemRepository.findAll();

        //then
        assertThat(basses).contains(fender, musicMan, sire, yamaha);
    }

    @Test
    void updateItem() {
        //given
        Item fender = new Item("fender", 2300000, 1);
        Item savedFender = itemRepository.save(fender);

        //when
        Item updateFender = new Item("fender-ultra", 2500000, 1);
        itemRepository.update(savedFender.getId(), updateFender);
        Item findFender = itemRepository.findById(savedFender.getId());

        //then
        assertThat(findFender.getItemName()).isEqualTo(updateFender.getItemName());
        assertThat(findFender.getPrice()).isEqualTo(updateFender.getPrice());
        assertThat(findFender.getQuantity()).isEqualTo(updateFender.getQuantity());

    }

}