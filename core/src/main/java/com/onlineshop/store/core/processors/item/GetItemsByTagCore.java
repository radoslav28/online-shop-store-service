package com.onlineshop.store.core.processors.item;

import com.onlineshop.store.api.exceptions.ServiceUnavailableException;
import com.onlineshop.store.api.model.ItemModel;
import com.onlineshop.store.api.operations.item.get.bytag.GetItemsByTagInput;
import com.onlineshop.store.api.operations.item.get.bytag.GetItemsByTagOperation;
import com.onlineshop.store.api.operations.item.get.bytag.GetItemsByTagResult;
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
public class GetItemsByTagCore implements GetItemsByTagOperation {

    private final ItemRepository itemRepository;
    private final ConversionService conversionService;

    @Override
    public GetItemsByTagResult process(GetItemsByTagInput input) {

        try {

            List<Item> items = itemRepository.findByTags_Id(UUID.fromString(input.getTagId()));

            List<ItemModel> itemModels = items
                    .stream()
                    .map(i -> conversionService.convert(i, ItemModel.class))
                    .toList();

            return GetItemsByTagResult
                    .builder()
                    .itemModels(itemModels)
                    .build();

        } catch (JDBCConnectionException e) {
            throw new ServiceUnavailableException();
        }
    }
}
