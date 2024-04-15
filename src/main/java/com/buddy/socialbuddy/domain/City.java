package com.buddy.socialbuddy.domain;

import com.buddy.socialbuddy.base.BaseDocument;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class City extends BaseDocument {

  private String name;
  private Integer plateNumber;
}
