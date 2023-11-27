package com.onlineshop.store.core.processors.item;

import com.onlineshop.store.api.exceptions.ServiceUnavailableException;
import com.onlineshop.store.api.model.ItemModel;
import com.onlineshop.store.api.operations.item.get.byIds.GetItemsByIdsInput;
import com.onlineshop.store.api.operations.item.get.byIds.GetItemsByIdsOperation;
import com.onlineshop.store.api.operations.item.get.byIds.GetItemsByIdsResult;
import com.onlineshop.store.persistence.entities.Item;
import com.onlineshop.store.persistence.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetItemsByIdsCore implements GetItemsByIdsOperation {

    private final ItemRepository itemRepository;
    private final ConversionService conversionService;

    @Override
    public GetItemsByIdsResult process(GetItemsByIdsInput input) {

        try {

            List<Item> items = itemRepository.findByIdIn(input
                    .getItemsIds()
                    .stream()
                    .map(UUID::fromString)
                    .toList());

            List<ItemModel> itemModels = items
                    .stream()
                    .map(i -> conversionService.convert(i, ItemModel.class))
                    .toList();

            return GetItemsByIdsResult
                    .builder()
                    .itemModels(itemModels)
                    .build();

        } catch (JDBCConnectionException e) {
            throw new ServiceUnavailableException();
        }
    }
}
