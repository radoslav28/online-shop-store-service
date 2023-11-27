package com.onlineshop.store.core.processors.item;

import com.onlineshop.store.api.exceptions.DisallowedIdException;
import com.onlineshop.store.api.exceptions.ServiceUnavailableException;
import com.onlineshop.store.api.operations.item.create.CreateItemInput;
import com.onlineshop.store.api.operations.item.create.CreateItemOperation;
import com.onlineshop.store.api.operations.item.create.CreateItemResult;
import com.onlineshop.store.persistence.entities.Item;
import com.onlineshop.store.persistence.entities.Tag;
import com.onlineshop.store.persistence.entities.Vendor;
import com.onlineshop.store.persistence.repositories.ItemRepository;
import com.onlineshop.store.persistence.repositories.TagRepository;
import com.onlineshop.store.persistence.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateItemCore implements CreateItemOperation {

    private final ItemRepository itemRepository;
    private final VendorRepository vendorRepository;
    private final TagRepository tagRepository;
    private final ConversionService conversionService;

    @Override
    public CreateItemResult process(CreateItemInput input) {

        try {

            Vendor vendor = vendorRepository
                    .findById(UUID.fromString(input.getVendorId()))
                    .orElseThrow(() -> new DisallowedIdException(input.getVendorId()));

            List<Tag> tags = tagRepository.findByIdIn(input.getTagsIds()
                            .stream()
                            .map(UUID::fromString)
                            .toList());

            Item item = conversionService.convert(input, Item.class);
            item.setVendor(vendor);
            item.setTags(tags);

            Item persisted = itemRepository.save(item);

            return CreateItemResult
                    .builder()
                    .id(String.valueOf(persisted.getId()))
                    .build();

        } catch (JDBCConnectionException e) {
            throw new ServiceUnavailableException();
        }
    }
}
