package com.onlineshop.store.api.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemModel {

    private String id;

    private String title;

    private String description;

    private VendorModel vendorModel;

    private List<MultimediaModel> multimediaModels;

    private List<TagModel> tagModels;
}
