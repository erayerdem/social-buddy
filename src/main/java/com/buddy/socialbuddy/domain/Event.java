package com.buddy.socialbuddy.domain;

import com.buddy.socialbuddy.base.BaseDocument;
import com.buddy.socialbuddy.client.dto.BubiletFile;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@NoArgsConstructor
public class Event extends BaseDocument implements Serializable {

  private String name;
  private String slug;
  private List<BubiletFile> files;
  private List<EventPoster> posters;
  private List<Integer> artists;
  private List<Integer> venues;
  private Boolean showInAllCities;
  private Integer order;
  private String type;
  private String location;
  private String masterCategoryId;
  private String categoryId;
  private Boolean isDeleted = Boolean.FALSE;
  private LocalDateTime deletedAt;
  private Integer cityId;
  private Integer externalId;
  private int totalRemainingTickets;
  private Integer totalSoldTickets;
  private String eventDate;
  private Integer daysUntilEvent;
  private Boolean promoteOnly;
}
