package com.buddy.socialbuddy.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record BubiletArtist(
    @JsonProperty("id") Integer id,
    @JsonProperty("ad") String name,
    @JsonProperty("soyad") String surname,
    @JsonProperty("sanatciTipi") Integer artistType,
    @JsonProperty("dogumYeri") String birthPlace,
    @JsonProperty("biografi") String biography,
    @JsonProperty("dosyalar") List<BubiletFile> bubiletFiles,
    @JsonProperty("slug") String slug,
    @JsonProperty("etkinlikAdedi") Integer eventCount,
    @JsonProperty("seoBaslik") String seoTitle,
    @JsonProperty("seoAnahtar") String seoKeyword,
    @JsonProperty("seoAciklama") String seoDescription,
    @JsonProperty("adiSoyadi") String fullName) {}
