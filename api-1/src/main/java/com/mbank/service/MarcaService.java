package com.mbank.service;

import com.mbank.dto.MarcaDTO;
import com.mbank.repository.MarcaRepository;
import io.quarkus.cache.CacheResult;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class MarcaService {

    @Inject
    private MarcaRepository marcaRepository;

    @CacheResult(cacheName = "marcas-cache")
    public List<MarcaDTO> findAll() {
        return marcaRepository.getAll();
    }
}
