package com.mdasdead.external;

import com.mdasdead.dto.MarcaModeloDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/v1/carros/marcas")
@RegisterRestClient(configKey = "fipe-api")
public interface FipeClient {

    @GET
    @Path("/{codigoMarca}/modelos")
    @Produces(MediaType.APPLICATION_JSON)
    MarcaModeloDTO getRemoteByMarca(final Integer codigoMarca);
}
