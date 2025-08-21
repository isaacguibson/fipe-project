package com.mbank.queue;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class FipeProducer {

    @Channel("fipechannel")
    Emitter<String> emitter;

    public void send(String listJSON) {
        emitter.send(listJSON);
    }
}
