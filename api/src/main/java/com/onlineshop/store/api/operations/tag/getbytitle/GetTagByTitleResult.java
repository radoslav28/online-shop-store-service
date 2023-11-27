package com.onlineshop.store.api.operations.tag.getbytitle;

import com.onlineshop.store.api.base.ProcessorResult;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetTagByTitleResult implements ProcessorResult {
    private String id;
    private String title;
}
