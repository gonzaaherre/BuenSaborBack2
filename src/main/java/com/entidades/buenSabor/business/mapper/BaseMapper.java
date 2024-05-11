package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.BaseDto;
import com.entidades.buenSabor.domain.entities.Base;

import java.util.List;

public interface BaseMapper<E extends Base,D extends BaseDto,DC>{
    public D toDTO(E source);
    public E toEntity(D source);
    public E toEntityCreate(DC source);
    public List<D> toDTOsList(List<E> source);
}
