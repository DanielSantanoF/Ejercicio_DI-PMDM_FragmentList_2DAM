package com.dsantano.segundo_ejercicio_fragmentlist.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AmazonProduct {

    private String title;
    private String url;
    private double price;
    private boolean prime;
    private String date;
    private boolean free_shipping;
    private float rate;
}
