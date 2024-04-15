package com.buddy.socialbuddy.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BubiletFile(
        @JsonProperty("id") Integer id,
        @JsonProperty("url") String url,
        @JsonProperty("gosterimYeri") String displayPlace,
        @JsonProperty("genislik") Integer width,
        @JsonProperty("yukseklik") Integer height,
        @JsonProperty("sira") Integer order
) {}
