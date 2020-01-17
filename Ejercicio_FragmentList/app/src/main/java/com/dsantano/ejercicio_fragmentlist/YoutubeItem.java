package com.dsantano.ejercicio_fragmentlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YoutubeItem {
    private String vidUrl;
    private String authorUrl;
    private String tittle;
    private String author;
    private String duration;
    private long views;
}
