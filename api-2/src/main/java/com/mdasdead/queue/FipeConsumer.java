package com.mdasdead.queue;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdasdead.dto.MarcaModeloDTO;
import com.mdasdead.entity.Marca;
import com.mdasdead.entity.Veiculo;
import com.mdasdead.external.FipeClient;
import com.mdasdead.repository.MarcaRepository;
import com.mdasdead.repository.VeiculoRepository;
import com.mdasdead.service.MarcaService;
import com.mdasdead.service.VeiculoService;
import io.quarkus.logging.Log;
import io.smallrye.reactive.messaging.annotations.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@ApplicationScoped
public class FipeConsumer {

    @Inject
    MarcaRepository marcaRepository;

    @Inject
    @RestClient
    FipeClient fipeClient;

    @Inject
    VeiculoRepository veiculoRepository;

    @Inject
    VeiculoService veiculoService;

    @Incoming("fipequeue")
    @Blocking
    public void getData(String msg) {
        Log.info("INICIALIZANDO CARGA: " + msg);

        // Realizar carga inicial se banco vazio
        if(marcaRepository.countAll() == 0) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                List<Marca> marcas = objectMapper.readValue(msg, new TypeReference<>() {
                });
                if(nonNull(marcas) && !marcas.isEmpty()) {
                    marcas.forEach(marca -> {
                        MarcaModeloDTO marcaModelo = fipeClient.getRemoteByMarca(marca.getCodigo());
                        var marcaSalva = marcaRepository.save(marca);
                        Log.info("SALVANDO MARCA: " + marcaSalva.getCodigo() + " - " + marca.getNome());
                        var veiculos = veiculoService.getModelosByMarcaModelo(marcaModelo);
                        veiculos.forEach(veiculo -> {
                            veiculo.setMarca(marcaSalva);
                            veiculoRepository.save(veiculo);
                            Log.info("SALVANDO VEICULO: " + veiculo.getCodigo() + " - " + veiculo.getModelo());
                        });
                    });
                }

            } catch (Exception e) {
                throw new RuntimeException("Não foi possível persistir as marcas");
            }
        }

        Log.info("FIM DA CARGA");
    }
}
