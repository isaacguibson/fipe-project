package com.mbank.service;

import com.mbank.dto.MarcaDTO;
import com.mbank.repository.MarcaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class MarcaService {

    @Inject
    private MarcaRepository marcaRepository;

    public List<MarcaDTO> findAll() {
        return marcaRepository.getAll();
    }
}
