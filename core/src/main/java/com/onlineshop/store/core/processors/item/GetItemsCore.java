package com.onlineshop.store.core.processors.item;

import com.onlineshop.store.api.exceptions.ServiceUnavailableException;
import com.onlineshop.store.api.model.ItemModel;
import com.onlineshop.store.api.operations.item.get.all.GetItemsInput;
import com.onlineshop.store.api.operations.item.get.all.GetItemsOperation;
import com.onlineshop.store.api.operations.item.get.all.GetItemsResult;
import com.onlineshop.store.persistence.entities.Item;
import com.onlineshop.store.persistence.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetItemsCore implements GetItemsOperation {

    private final ItemRepository itemRepository;
    private final ConversionService conversionService;

    @Override
    public GetItemsResult process(GetItemsInput input) {

        try {

            List<Item> items = itemRepository.findAll();

            List<ItemModel> itemModels = items
                    .stream()
                    .map(i -> conversionService.convert(i, ItemModel.class))
                    .toList();

            return GetItemsResult
                    .builder()
                    .itemModels(itemModels)
                    .build();

        } catch (JDBCConnectionException e) {
            throw new ServiceUnavailableException();
        }
    }
}
