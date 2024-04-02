package com.cybage.winepark.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "wine")
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer wineId;
    @NotNull
    private Integer quantity;
    @NotNull
    private String category;
    @NotNull
    private String name;
    @NotNull
    private Double price;

}
