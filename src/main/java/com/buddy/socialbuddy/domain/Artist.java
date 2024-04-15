package com.buddy.socialbuddy.domain;

import com.buddy.socialbuddy.base.BaseDocument;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Artist extends BaseDocument {

  private Integer externalId;
  private String name;
  private String surname;
  private Integer artistType;
  private String birthPlace;
  private String biography;
  private List<ArtistImage> images;
  private String slug;
  private Integer eventCount;
  private String fullName;
}
