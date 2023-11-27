package com.onlineshop.store.persistence.repositories;

import com.onlineshop.store.persistence.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface TagRepository extends JpaRepository<Tag, UUID> {
    List<Tag> findByIdIn (List<UUID> ids);
    List<Tag> findByItems_Id (UUID itemId);
}
