package com.mbank.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbank.dto.MarcaDTO;
import com.mbank.external.FipeClient;
import com.mbank.queue.FipeProducer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class GerenciadorFipe {

    @Inject
    @RestClient
    FipeClient fipeClient;

    @Inject
    FipeProducer fipeProducer;

    public List<MarcaDTO> getMarcas() throws Exception {
        var resultado = fipeClient.getMarcas();
        ObjectMapper mapper = new ObjectMapper();
        fipeProducer.send(mapper.writeValueAsString(resultado));
        return resultado;
    }

}
