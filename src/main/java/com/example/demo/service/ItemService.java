package com.example.demo.service;

import com.example.demo.exception.ExceptionMessages;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.errors.ControllerAdvice;
import com.example.demo.model.Invoice;
import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ItemService extends GeneralDemoService{
    @Autowired
    ItemRepository itemRepository;

    public List<Item> getItems() {
        Specification distinctSpec = (root, query, cb) -> {
            query.distinct(true);
            return null;
        };

        return itemRepository.findAll(distinctSpec);
    }

    public Optional<Item> getItemById(long itemId) {
        Optional<Item> optionalitem = itemRepository.findItemById(itemId);

        if (!(optionalitem.isPresent())){
            throw new ResourceNotFoundException(ExceptionMessages.ENTITY_NOT_FOUND);
        }
        return optionalitem;
    }

    public Item postItem(Item newItem) {

        return itemRepository.save(newItem);
    }


    public Item putItem(Item item, long itemId){
        try {
            Optional<Item> itemupdated = itemRepository.findItemById(itemId);
            itemupdated.get().setItem_name(item.getItem_name());
            itemupdated.get().setItem_price(item.getItem_price());
            return itemRepository.save(itemupdated.get());
        }catch(Exception e) {
            throw new RuntimeException(ExceptionMessages.ENTITY_NOT_FOUND);
        }
    }

    public void deleteEntity(Long itemId) {
        Optional<Item> itemEntity = itemRepository.findItemById(itemId);

        if (!(itemEntity.isPresent())) {
            throw new ResourceNotFoundException(ExceptionMessages.ENTITY_NOT_FOUND) ;
        }
        itemRepository.delete(itemEntity.get());
    }
}
