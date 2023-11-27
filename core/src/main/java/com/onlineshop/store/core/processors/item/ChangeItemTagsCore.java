package com.onlineshop.store.core.processors.item;

import com.onlineshop.store.api.exceptions.DisallowedIdException;
import com.onlineshop.store.api.exceptions.ServiceUnavailableException;
import com.onlineshop.store.api.operations.item.changetags.ChangeItemTagsInput;
import com.onlineshop.store.api.operations.item.changetags.ChangeItemTagsOperation;
import com.onlineshop.store.api.operations.item.changetags.ChangeItemTagsResult;
import com.onlineshop.store.persistence.entities.Item;
import com.onlineshop.store.persistence.repositories.ItemRepository;
import com.onlineshop.store.persistence.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChangeItemTagsCore implements ChangeItemTagsOperation {

    private final ItemRepository itemRepository;
    private final TagRepository tagRepository;

    @Override
    public ChangeItemTagsResult process(ChangeItemTagsInput input) {

        try {

            Item item = itemRepository
                    .findById(UUID.fromString(input.getItemId()))
                    .orElseThrow(() -> new DisallowedIdException(input.getItemId()));

            item.setTags(tagRepository.findByIdIn(input
                    .getTagIds()
                    .stream()
                    .map(UUID::fromString)
                    .toList()));

            itemRepository.save(item);

            return ChangeItemTagsResult.builder().build();

        } catch (JDBCConnectionException e) {
            throw new ServiceUnavailableException();
        }
    }
}
