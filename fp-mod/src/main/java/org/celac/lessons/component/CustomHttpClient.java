package org.celac.lessons.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.celac.lessons.models.Item;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

public class CustomHttpClient {
   private static final HttpClient client = HttpClient.newHttpClient();

    public static CompletableFuture<Void> fetchPage (URI uri,
                                                      Function<HttpResponse,Optional<List<Item>>> bodyConverter,
                                                      Consumer<Optional<List<Item>>> respConsumer) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", "application/json")
                .GET()
                .build();
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(bodyConverter).thenAccept(respConsumer);
    }
}
