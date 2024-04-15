package com.buddy.socialbuddy.domain;

import com.buddy.socialbuddy.base.BaseDocument;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Category extends BaseDocument {

    private String name;
    private String description;
    private String icon;
    private String color;
    @Indexed
    private String parentId;
    private String parentName;

    public boolean isMasterCategory() {
        return Objects.isNull(parentId);
    }


}
