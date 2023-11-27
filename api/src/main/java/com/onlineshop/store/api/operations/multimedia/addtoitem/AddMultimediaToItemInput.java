package com.onlineshop.store.api.operations.multimedia.addtoitem;

import com.onlineshop.store.api.base.ProcessorInput;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddMultimediaToItemInput implements ProcessorInput {

    @UUID
    private String itemId;

    private List<String> multimedia;
}
