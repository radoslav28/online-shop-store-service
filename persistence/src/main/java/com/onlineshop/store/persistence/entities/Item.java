package com.onlineshop.store.persistence.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(columnDefinition = "tinyint(1) default 1")
    private Boolean isAvailable;

    @ManyToOne
    private Vendor vendor;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "item_id")
    private List<Multimedia> multimedia;

    @ManyToMany
    @JoinTable(
            name = "items_tags",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;

    @Builder
    public Item(UUID id, String title, String description, Vendor vendor, List<Multimedia> multimedia, List<Tag> tags) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isAvailable = true;
        this.vendor = vendor;
        this.multimedia = multimedia;
        this.tags = tags;
    }
}
