package com.entidades.buenSabor.business.service.Base;

import com.entidades.buenSabor.domain.entities.Base;

import java.io.Serializable;
import java.util.List;

public interface BaseService <E extends Base, ID extends Serializable>{
    public E create(E request);
    public E getById(ID id);
    public List<E> getAll();
    public void deleteById(ID id);
    public E update(E request, ID id);
}
