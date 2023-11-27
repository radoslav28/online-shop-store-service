package com.onlineshop.store.api.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    private String id;
    private String title;
    private String description;
    private Vendor vendor;
    private List<Multimedia> multimedia;
    private List<Tag> tags;
}
