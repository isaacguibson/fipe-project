package com.mbank.controller;

import com.mbank.dto.VeiculoDTO;
import com.mbank.service.VeiculoService;
import io.quarkus.cache.CacheResult;
import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/veiculos")
public class VeiculoResource {

    @Inject
    VeiculoService veiculoService;

    @GET
    @Path("/by-marca/{idMarca}")
    @Authenticated
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByMarca(@PathParam("idMarca") final Integer idMarca) {
        try {
            return Response.ok(veiculoService.findDTOByMarca(idMarca)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Não foi possível processar a requisição").build();
        }
    }

    @PUT
    @Authenticated
    @Path("/{idVeiculo}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getByMarca(final VeiculoDTO veiculoDTO, @PathParam("idVeiculo") final Integer idVeiculo) {
        try {
            return Response.ok(veiculoService.update(idVeiculo, veiculoDTO)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
