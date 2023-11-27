package com.onlineshop.store.api.operations.item.getbyid;

import com.onlineshop.store.api.base.ProcessorResult;
import com.onlineshop.store.api.model.Multimedia;
import com.onlineshop.store.api.model.Tag;
import com.onlineshop.store.api.model.Vendor;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetItemByIdResult implements ProcessorResult {
    private String id;
    private String title;
    private String description;
    private Vendor vendor;
    private List<Multimedia> multimedia;
    private List<Tag> tags;
}
