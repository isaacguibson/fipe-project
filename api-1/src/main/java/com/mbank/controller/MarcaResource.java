package com.mbank.controller;

import com.mbank.dto.MarcaDTO;
import com.mbank.service.GerenciadorFipe;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/marca")
public class MarcaResource {

    @Inject
    GerenciadorFipe gerenciadorFipe;

    @GET
    @Path("/carga-inicial")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MarcaDTO> cargaInicial() {
        try {
            return gerenciadorFipe.getMarcas();
        } catch (Exception e) {
            throw new WebApplicationException("Não foi possível realizar carga inicial de marcas", Response.Status.INTERNAL_SERVER_ERROR);
        }

    }
}
