package com.mdasdead.service;

import com.mdasdead.entity.Marca;
import com.mdasdead.repository.MarcaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class MarcaService {

    @Inject
    MarcaRepository marcaRepository;

    @Transactional
    public Marca save(final Marca marca) {
        return marcaRepository.save(marca);
    }

    public Long countAll() {
        return marcaRepository.countAll();
    }
}
