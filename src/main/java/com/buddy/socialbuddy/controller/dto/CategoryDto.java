package com.buddy.socialbuddy.controller.dto;

public record CategoryDto(
    String id, String name, String description, String icon, String color, Integer externalId) {}
