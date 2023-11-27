package com.onlineshop.store.core.processors.item;

import com.onlineshop.store.api.exceptions.DisallowedIdException;
import com.onlineshop.store.api.exceptions.ServiceUnavailableException;
import com.onlineshop.store.api.operations.item.getbyid.GetItemByIdInput;
import com.onlineshop.store.api.operations.item.getbyid.GetItemByIdOperation;
import com.onlineshop.store.api.operations.item.getbyid.GetItemByIdResult;
import com.onlineshop.store.persistence.entities.Item;
import com.onlineshop.store.persistence.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetItemByIdCore implements GetItemByIdOperation {

    private final ItemRepository itemRepository;
    private final ConversionService conversionService;

    @Override
    public GetItemByIdResult process(GetItemByIdInput input) {

        try {

            Item item = itemRepository
                    .findById(UUID.fromString(input.getItemId()))
                    .orElseThrow(() -> new DisallowedIdException(input.getItemId()));

            return conversionService.convert(item, GetItemByIdResult.class);

        } catch (JDBCConnectionException e) {
            throw new ServiceUnavailableException();
        }
    }
}
