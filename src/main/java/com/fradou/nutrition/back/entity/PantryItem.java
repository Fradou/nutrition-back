package com.fradou.nutrition.back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Entity
@Table(name="pantry_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PantryItem {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_pantry_item")
    private Integer id;

    private LocalDate expirationDate;

    @Min(0)
    private Integer weight;

    @Min(0)
    private Integer share;

    // TODO Lazy
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="id_food")
    private Food food;
}
