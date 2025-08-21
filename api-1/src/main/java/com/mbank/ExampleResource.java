package com.mbank;

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

@Path("/status")
public class ExampleResource {

    @Inject
    GerenciadorFipe gerenciadorFipe;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Api-1 is ok!";
    }
}
