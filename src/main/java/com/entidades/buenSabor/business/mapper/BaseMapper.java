package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.BaseDto;
import com.entidades.buenSabor.domain.entity.Base;

import java.util.List;

public interface BaseMapper<E extends Base,D extends BaseDto>{
    public D toDTO(E source);
    public E toEntity(D source);
    public List<D> toDTOsList(List<E> source);
    public List<E> toEntitiesList(List<D> source);
}
