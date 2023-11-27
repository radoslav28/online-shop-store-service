package com.onlineshop.store.core.processors.item;

import com.onlineshop.store.api.exceptions.DisallowedIdException;
import com.onlineshop.store.api.exceptions.ServiceUnavailableException;
import com.onlineshop.store.api.operations.item.update.UpdateItemInput;
import com.onlineshop.store.api.operations.item.update.UpdateItemOperation;
import com.onlineshop.store.api.operations.item.update.UpdateItemResult;
import com.onlineshop.store.persistence.entities.Item;
import com.onlineshop.store.persistence.repositories.ItemRepository;
import com.onlineshop.store.persistence.repositories.TagRepository;
import com.onlineshop.store.persistence.repositories.VendorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateItemCore implements UpdateItemOperation {

    private final ItemRepository itemRepository;
    private final VendorRepository vendorRepository;
    private final TagRepository tagRepository;
    private final ConversionService conversionService;

    @Override
    @Transactional
    public UpdateItemResult process(UpdateItemInput input) {

        try {

            Item item = itemRepository
                    .findById(UUID.fromString(input.getItemId()))
                    .orElseThrow(() -> new DisallowedIdException(input.getItemId()));

            item.setTitle(input.getTitle());
            item.setDescription(input.getDescription());
            item.setVendor(vendorRepository
                    .findById(UUID.fromString(input.getVendorId()))
                    .orElseThrow(() -> new DisallowedIdException(input.getVendorId())));

            item.setTags(tagRepository
                    .findByIdIn(input
                            .getTagIds()
                            .stream()
                            .map(UUID::fromString)
                            .toList()));

            itemRepository.save(item);

            return conversionService.convert(item, UpdateItemResult.class);

        } catch (JDBCConnectionException e) {
            throw new ServiceUnavailableException();
        }
    }
}
