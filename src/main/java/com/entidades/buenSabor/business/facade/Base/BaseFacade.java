package com.entidades.buenSabor.business.facade.Base;

import com.entidades.buenSabor.MyException.RestrictDeleteException;
import com.entidades.buenSabor.domain.dto.BaseDto;

import java.io.Serializable;
import java.util.List;
//DC dto create
//DE dto Edit
public interface BaseFacade <D extends BaseDto, DC, DE, ID extends Serializable>{
    public D createNew(DC request);
    public D getById(Long id);
    public List<D> getAll();
    public void deleteById(Long id) throws RestrictDeleteException;
    public D update(DE request, Long id);
}
