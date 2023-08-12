package com.example.finalexamsetc.Repositories;

import com.example.finalexamsetc.Entities.Item;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findItemById(long kw);
}
