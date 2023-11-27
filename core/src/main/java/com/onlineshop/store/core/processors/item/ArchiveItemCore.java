package com.onlineshop.store.core.processors.item;

import com.onlineshop.store.api.exceptions.DisallowedIdException;
import com.onlineshop.store.api.exceptions.ServiceUnavailableException;
import com.onlineshop.store.api.operations.item.archive.ArchiveItemInput;
import com.onlineshop.store.api.operations.item.archive.ArchiveItemOperation;
import com.onlineshop.store.api.operations.item.archive.ArchiveItemResult;
import com.onlineshop.store.persistence.entities.Item;
import com.onlineshop.store.persistence.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArchiveItemCore implements ArchiveItemOperation {

    private final ItemRepository itemRepository;

    @Override
    public ArchiveItemResult process(ArchiveItemInput input) {

        try {

            Item item = itemRepository
                    .findById(UUID.fromString(input.getItemId()))
                    .orElseThrow(() -> new  DisallowedIdException(input.getItemId()));

            item.setIsAvailable(false);
            itemRepository.save(item);

            return ArchiveItemResult.builder().build();

        } catch (JDBCConnectionException e) {
            throw new ServiceUnavailableException();
        }
    }
}
