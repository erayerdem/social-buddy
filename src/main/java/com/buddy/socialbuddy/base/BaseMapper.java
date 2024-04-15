package com.buddy.socialbuddy.base;

import java.util.List;
import org.mapstruct.MapperConfig;

@MapperConfig
public interface BaseMapper<E, D> {


    E toEntity(D dto);

    D toDto(E entity);

    List<D> toDtos(List<E> entities);

    List<E> toEntities(List<D> dtos);
}