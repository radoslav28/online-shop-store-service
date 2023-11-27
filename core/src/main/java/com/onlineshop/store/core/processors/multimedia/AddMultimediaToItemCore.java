package com.onlineshop.store.core.processors.multimedia;

import com.onlineshop.store.api.exceptions.DisallowedIdException;
import com.onlineshop.store.api.exceptions.ServiceUnavailableException;
import com.onlineshop.store.api.operations.multimedia.AddMultimediaToItemInput;
import com.onlineshop.store.api.operations.multimedia.AddMultimediaToItemOperation;
import com.onlineshop.store.api.operations.multimedia.AddMultimediaToItemResult;
import com.onlineshop.store.persistence.entities.Item;
import com.onlineshop.store.persistence.entities.Multimedia;
import com.onlineshop.store.persistence.repositories.ItemRepository;
import com.onlineshop.store.persistence.repositories.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddMultimediaToItemCore implements AddMultimediaToItemOperation {

    private final ItemRepository itemRepository;
    private final MultimediaRepository multimediaRepository;

    @Override
    public AddMultimediaToItemResult process(AddMultimediaToItemInput input) {

        try {

            Item item = itemRepository
                    .findById(UUID.fromString(input.getItemId()))
                    .orElseThrow(() -> new DisallowedIdException(input.getItemId()));

            List<Multimedia> multimediaList = item.getMultimedia();

            List<Multimedia> multimedia = multimediaRepository.saveAll(input
                    .getMultimedia()
                    .stream()
                    .map(m -> Multimedia.builder().url(m).build())
                    .toList());

            multimediaList.addAll(multimedia);
            item.setMultimedia(multimediaList);
            itemRepository.save(item);

            return AddMultimediaToItemResult.builder().build();

        } catch (JDBCConnectionException e) {
            throw new ServiceUnavailableException();
        }
    }
}
