package com.example.demo.controllar;

import com.example.demo.controllar.dto.InvoiceDto;
import com.example.demo.controllar.dto.InvoiceItemDto;
import com.example.demo.controllar.dto.ItemDto;
import com.example.demo.controllar.mapper.ControllerMappers;
import com.example.demo.model.Invoice;
import com.example.demo.model.InvoiceItem;
import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/items")
@RestController
public class ItemControllar extends GeneralController{

@Autowired
    ItemService itemService;

    @GetMapping
    public List<ItemDto> getItems() {
        List<Item> items= itemService.getItems();
        List<ItemDto> itemDtos = ControllerMappers.mapItems(items);
        return  itemDtos;
    }

    @GetMapping("/{id}")
    public ItemDto getItemById(@PathVariable ("id") Long ItemId) {
        Optional<Item> item= itemService.getItemById(ItemId);
        ItemDto itemDto = ControllerMappers.mapItemDto(item.get());
        return  itemDto;
    }

    @PostMapping()
    public ResponseEntity<ItemDto> craeteInvoiceItem(@RequestBody ItemDto itemDto) {

        Item newItem = ControllerMappers.mapItem(itemDto);
        ItemDto createdItemDto = ControllerMappers.mapItemDto(itemService.postItem(newItem));
        return new ResponseEntity(createdItemDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public void updateItem(@PathVariable ("id") long itemId ,
                                  @RequestBody ItemDto itemDto){
        Item item = ControllerMappers.mapItem(itemDto);
       ControllerMappers.mapItemDto(itemService.putItem(item,itemId));
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable ("id") long itemId){
        itemService.deleteEntity(itemId);

    }

}
