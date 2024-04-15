package com.buddy.socialbuddy.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtistImage {
  private Integer id;
  private String url;
  private String displayPlace;
  private Integer width;
  private Integer height;
  private Integer order;
}
