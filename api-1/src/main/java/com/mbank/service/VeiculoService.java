package com.mbank.service;

import com.mbank.dto.VeiculoDTO;
import com.mbank.entity.Veiculo;
import com.mbank.repository.VeiculoRepository;
import io.quarkus.cache.CacheInvalidateAll;
import io.quarkus.cache.CacheResult;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@ApplicationScoped
public class VeiculoService {

    @Inject
    private VeiculoRepository veiculoRepository;

    @CacheResult(cacheName = "veiculos-by-marca-cache")
    public List<VeiculoDTO> findDTOByMarca(final Integer idMarca) {
        return veiculoRepository.findDTOByMarca(idMarca);
    }

    @Transactional
    public VeiculoDTO update(final Integer idVeiculo, final VeiculoDTO veiculoDTO) {
        validateUpdate(idVeiculo, veiculoDTO);
        var veiculoToSave = veiculoRepository.findById(idVeiculo);
        if(isNull(veiculoToSave)) {
            throw new RuntimeException("Veiculo não encontrado");
        }
        changeVeiculoData(veiculoToSave, veiculoDTO);
        this.clearCache();
        return new VeiculoDTO(veiculoToSave);
    }

    private void changeVeiculoData(final Veiculo veiculo, final VeiculoDTO veiculoDTO) {
        if(nonNull(veiculoDTO.getModelo()) && !veiculoDTO.getModelo().isEmpty()) {
            veiculo.setModelo(veiculoDTO.getModelo());
        }
        veiculo.setObservacao(veiculoDTO.getObservacao());
    }

    private void validateUpdate(final Integer idVeiculo, final VeiculoDTO veiculoDTO) {
        if(isNull(veiculoDTO)) {
            throw new RuntimeException("Nenhum veículo deve foi informado");
        }

        if(isNull(idVeiculo)) {
            throw new RuntimeException("O id do veículo deve ser informado");
        }
    }

    @CacheInvalidateAll(cacheName = "veiculos-by-marca-cache")
    public void clearCache() {}
}
