package com.buddy.socialbuddy.domain;

import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EventPoster implements Serializable {
  private String url;
  private String otherStuffs;
}
