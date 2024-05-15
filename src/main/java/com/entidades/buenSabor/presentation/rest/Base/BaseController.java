package com.entidades.buenSabor.presentation.rest.Base;

import com.entidades.buenSabor.MyException.RestrictDeleteException;
import com.entidades.buenSabor.domain.dto.BaseDto;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseController <D extends BaseDto, DC, DE, ID extends Serializable> {
    ResponseEntity<D> getById(ID id);

    ResponseEntity<List<D>> getAll();

    ResponseEntity<D> create(DC entity);

    ResponseEntity<D> edit(DE entity, ID id);

    ResponseEntity<?> deleteById(ID id) throws RestrictDeleteException;
}