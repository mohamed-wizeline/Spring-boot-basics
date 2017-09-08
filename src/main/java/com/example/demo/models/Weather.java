package com.example.demo.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    private Double temp;
    private Double relativeHumid;
    private Integer windSpd;
    private Integer windDir;
}
