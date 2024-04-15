package com.buddy.socialbuddy.base.dto;

import java.util.List;
import lombok.Builder;

@Builder
public record PageableResponse<T>(long count, List<T> data) {}