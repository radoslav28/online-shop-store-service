package com.onlineshop.store.api.operations.multimedia.getbyitem;

import com.onlineshop.store.api.base.ProcessorInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetMultimediaByItemInput implements ProcessorInput {

    @UUID
    @NotBlank
    private String itemId;
}
