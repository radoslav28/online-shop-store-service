package com.onlineshop.store.api.operations.item.getall;

import com.onlineshop.store.api.base.ProcessorResult;
import com.onlineshop.store.api.model.Item;
import lombok.*;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetItemsResult implements ProcessorResult {
    private List<Item> items;
}
