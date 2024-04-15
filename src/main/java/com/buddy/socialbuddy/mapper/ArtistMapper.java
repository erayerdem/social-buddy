package com.buddy.socialbuddy.mapper;

import com.buddy.socialbuddy.base.BaseMapper;
import com.buddy.socialbuddy.client.dto.BubiletArtist;
import com.buddy.socialbuddy.domain.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ArtistMapper extends BaseMapper<Artist, BubiletArtist> {

  @Mapping(source = "id", target = "externalId")
  @Mapping(ignore = true, target = "id")
  @Mapping(source = "bubiletFiles", target = "images")
  Artist toEntity(BubiletArtist dto);
}
