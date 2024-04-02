package com.cybage.winepark.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class WineDto {
    private Integer wineId;
    private Integer quantity;
    private String category;
    private String name;
    private Double price;
}
