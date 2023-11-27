package com.onlineshop.store.api.operations.item.changetags;

import com.onlineshop.store.api.base.ProcessorInput;
import com.onlineshop.store.api.model.Tag;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChangeItemTagsInput implements ProcessorInput {

    @UUID
    private String itemId;

    private List<Tag> tags;
}
