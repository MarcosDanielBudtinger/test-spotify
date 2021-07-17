package com.test.spotify.spotifyintegration.dto;

import com.wrapper.spotify.model_objects.specification.Image;
import lombok.Data;

@Data
public class AlbumDTO {
    private String id;
    private String name;
    private Image[] images;
} 
