package com.example.doctor.shared.baseMapper;

import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;

public interface BaseMapper<T, DTO> {
    DTO map(T t);

    T unMap(DTO dto);

    T unMap(@MappingTarget T t, DTO dto);

    List<DTO> map(List<T> t);

    Set<DTO> map(Set<T> t);

    List<T> unMap(List<DTO> dto);

}