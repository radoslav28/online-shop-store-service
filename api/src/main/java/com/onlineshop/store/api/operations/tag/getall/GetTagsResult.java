package com.onlineshop.store.api.operations.tag.getall;

import com.onlineshop.store.api.base.ProcessorResult;
import com.onlineshop.store.api.model.TagModel;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetTagsResult implements ProcessorResult {
    private List<TagModel> tagModels;
}
