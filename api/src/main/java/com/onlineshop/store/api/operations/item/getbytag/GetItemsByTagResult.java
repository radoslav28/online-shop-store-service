package com.onlineshop.store.api.operations.item.getbytag;

import com.onlineshop.store.api.base.ProcessorResult;
import com.onlineshop.store.api.model.ItemModel;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetItemsByTagResult implements ProcessorResult {
    List<ItemModel> itemModels;
}
