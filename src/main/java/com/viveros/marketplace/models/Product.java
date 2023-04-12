package com.viveros.marketplace.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "product")
@NoArgsConstructor
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "product_id")
    private Long id;

    @Getter @Setter @Column(name = "product_name")
    private String name;

    @Getter @Setter @Column(name = "product_category")
    private String category;

    @Getter @Setter @Column(name = "product_sub_category")
    private String subCategory;

    @Getter @Setter @Column(name = "product_price")
    private long price;

    @Getter @Setter @Column(name = "product_discount")
    private long discount;

    @Getter @Setter @Column(name = "url_img")
    private String url;

}

