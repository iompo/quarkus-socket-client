package com.example.socket;

import io.quarkus.logging.Log;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import java.net.URI;

@ApplicationScoped
public class Application {

    void onStart(@Observes StartupEvent ev) {
        try {
            try (Session session = ContainerProvider.getWebSocketContainer().connectToServer(NodeClient.class, new URI("ws://localhost:9009/test"))) {
                session.getAsyncRemote().sendText("some");
            }
        } catch (Exception e) {
            Log.error("failed to send message", e);
        }
    }
}
