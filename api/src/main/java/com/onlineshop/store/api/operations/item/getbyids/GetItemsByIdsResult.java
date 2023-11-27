package com.onlineshop.store.api.operations.item.getbyids;

import com.onlineshop.store.api.base.ProcessorResult;
import com.onlineshop.store.api.model.Item;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetItemsByIdsResult implements ProcessorResult {
    List<Item> items;
}
