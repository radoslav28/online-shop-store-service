package com.onlineshop.store.api.operations.item.get.byIds;

import com.onlineshop.store.api.base.ProcessorInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetItemsByIdsInput implements ProcessorInput {
    List<@UUID @NotBlank String> itemsIds;
}
