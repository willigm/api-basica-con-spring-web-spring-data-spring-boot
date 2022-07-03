package com.jdreyes.modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "stock")
public class Stock {
    @Id
    private Integer id_stock;
    @JoinColumn(name = "id_stock",referencedColumnName = "id")
    @OneToOne
    private Product product;
    @Column
    private Integer cantidad;
}
