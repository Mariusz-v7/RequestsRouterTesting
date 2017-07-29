package pl.mrugames.commons.router.client;

import org.springframework.stereotype.Component;
import pl.mrugames.commons.router.Request;
import pl.mrugames.commons.router.RequestMethod;
import pl.mrugames.commons.router.RequestType;
import pl.mrugames.commons.router.Response;
import pl.mrugames.commons.router.request_handlers.ObjectRequestHandler;

import java.util.UUID;
import java.util.function.Consumer;

@Component
public class TestConnector implements Connector {
    private final ObjectRequestHandler objectRequestHandler;

    private volatile Consumer<Response> consumer;

    private volatile String sessionId;

    TestConnector(ObjectRequestHandler objectRequestHandler) {
        this.objectRequestHandler = objectRequestHandler;
        this.sessionId = UUID.randomUUID().toString() + '-' + UUID.randomUUID().toString();
    }

    @Override
    public boolean isRunning() {
        return true;
    }

    @Override
    public void send(long l, String s, Object o, RequestMethod requestMethod, RequestType requestType) {
        objectRequestHandler.handleRequest(new Request(l, sessionId, "", s, requestMethod, o, requestType))
                .subscribe(consumer::accept);
    }

    @Override
    public void onResponseReceive(Consumer<Response> consumer) {
        this.consumer = consumer;
    }
}
