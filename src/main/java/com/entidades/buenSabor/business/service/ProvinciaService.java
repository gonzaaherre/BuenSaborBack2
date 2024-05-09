package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.entities.Provincia;
import java.util.List;

public interface ProvinciaService extends BaseService<Provincia, Long> {
    List<Provincia> findByPaisId(Long id);
}
