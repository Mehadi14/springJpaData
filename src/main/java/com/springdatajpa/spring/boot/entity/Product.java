package com.springdatajpa.spring.boot.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "tbl_products"
        ,schema = "ecommerce",
          uniqueConstraints = {
           @UniqueConstraint(name = "sku_unit",
                             columnNames = "stock_keeping_unit")
                  ,
                  @UniqueConstraint(name = "procutName",columnNames ="name")
          })
public class Product {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE
    , generator = "prodcut_generator")
    @SequenceGenerator(name = "prodcut_generator",
            sequenceName = "product_sequence_name",
           allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

     @Column(name = "stock_keeping_unit",nullable = false)
    private  String sku;

     @Column(nullable = false)
    private  String name;

    private  String description;

    private BigDecimal price;

    private boolean activeField;

    private  String imageUrl;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private  LocalDateTime lastUpdate;


//    public Long getId() {
//        return id;
//    }
//
//    public String getSku() {
//        return sku;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public boolean isActiveField() {
//        return activeField;
//    }
//
//    public void setDateCreated(LocalDateTime dateCreated) {
//        this.dateCreated = dateCreated;
//    }
//
//    public LocalDateTime getDateCreated() {
//        return dateCreated;
//    }
//
//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//
//
//    public LocalDateTime getLastUpdate() {
//        return lastUpdate;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setSku(String sku) {
//        this.sku = sku;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
//
//    public void setActiveField(boolean activeField) {
//        this.activeField = activeField;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
//
//
//
//    public void setLastUpdate(LocalDateTime lastUpdate) {
//        this.lastUpdate = lastUpdate;
//    }
}
