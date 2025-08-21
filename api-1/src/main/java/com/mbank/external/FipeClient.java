package com.mbank.external;

import com.mbank.dto.MarcaDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/api/v1/carros/marcas")
@RegisterRestClient(configKey = "fipe-api")
public interface FipeClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<MarcaDTO> getMarcas();
}
