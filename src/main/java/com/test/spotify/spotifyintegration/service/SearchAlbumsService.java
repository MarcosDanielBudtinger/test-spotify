package com.test.spotify.spotifyintegration.service;
import com.test.spotify.spotifyintegration.dto.AlbumDTO;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.AlbumSimplified;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.requests.data.search.simplified.SearchAlbumsRequest;
import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchAlbumsService {

  @Autowired
  private ClientCredentialsSpotifyService clientCredentialsSpotify;

  public List<AlbumDTO> getAlbums(String genre){
    SpotifyApi spotifyApiReturn = clientCredentialsSpotify.clientCredentials_Sync();
    List<AlbumDTO> lAlbum = searchAlbums_Sync(spotifyApiReturn, genre);
    return lAlbum;
  }
 
  private List<AlbumDTO> searchAlbums_Sync(SpotifyApi spotifyApi, String album) {
    try {
      SearchAlbumsRequest searchAlbumsRequest = spotifyApi.searchAlbums(album).limit(10).offset(0).build();
      final Paging<AlbumSimplified> albumSimplifiedPaging = searchAlbumsRequest.execute();

      AlbumSimplified[] lAlbum = albumSimplifiedPaging.getItems();
      List<AlbumDTO> lAlbumDto = new ArrayList<>();

      for(AlbumSimplified al: lAlbum){
        AlbumDTO dto = new AlbumDTO();
        dto.setId(al.getId());
        dto.setName(al.getName());
        dto.setImages(al.getImages());
        lAlbumDto.add(dto);
      }
      return lAlbumDto;

    } catch (IOException | SpotifyWebApiException | ParseException e) {
      System.out.println("Error: " + e.getMessage());
    }
    return null;
  }
}
