package com.fradou.nutrition.back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="food")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Food implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_food")
    private Integer id;

    @Column(nullable=false, unique=true)
    @NotNull
    private String label;

    @Min(0)
    @Max(100)
    @NotNull
    private double protein;

    @Min(0)
    @Max(100)
    @NotNull
    private double carbohydrate;

    @Min(0)
    @Max(100)
    @NotNull
    private double fat;

    @Min(0)
    @Max(1000)
    @NotNull
    private double calorie;
}
