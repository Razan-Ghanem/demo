package com.example.demo.repository;

import com.example.demo.model.Invoice;
import com.example.demo.model.Item;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item,Long>, JpaSpecificationExecutor<Item> {

    @Query("SELECT item from Item item"+ " WHERE item.id=?1")
    Optional<Item> findItemById(Long ItemId);
}
