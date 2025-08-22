package com.mbank.queue;

import io.quarkus.cache.CacheInvalidateAll;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class FipeProducer {

    @Channel("fipechannel")
    Emitter<String> emitter;

    public void send(String listJSON) {
        this.clearCache();
        emitter.send(listJSON);
    }

    @CacheInvalidateAll(cacheName = "marcas-cache")
    public void clearCache() {}
}
