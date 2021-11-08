package com.example.socket;

import io.quarkus.logging.Log;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@ClientEndpoint
public class NodeClient {

    @OnOpen
    public void open(Session session) {
        Log.error("connected");
    }

    @OnMessage
    void message(String msg) {
        Log.error("git the message: " + msg);
    }

}
