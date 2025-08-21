package com.mdasdead.service;

import com.mdasdead.dto.MarcaModeloDTO;
import com.mdasdead.entity.Veiculo;
import com.mdasdead.repository.VeiculoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Collections;
import java.util.List;

import static java.util.Objects.nonNull;

@ApplicationScoped
public class VeiculoService {

    @Inject
    private VeiculoRepository veiculoRepository;

    @Transactional
    public Veiculo save(final Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> getModelosByMarcaModelo(final MarcaModeloDTO marcaModelo) {
        if(nonNull(marcaModelo) && nonNull(marcaModelo.getModelos()) && !marcaModelo.getModelos().isEmpty()) {
            return marcaModelo.getModelos().stream().map(Veiculo::new).toList();
        }
        return Collections.emptyList();
    }

    public Long countAll() {
        return veiculoRepository.countAll();
    }
}
