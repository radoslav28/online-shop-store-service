package com.onlineshop.store.persistence.repositories;

import com.onlineshop.store.persistence.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
    List<Item> findByIdIn (List<UUID> ids);

}
