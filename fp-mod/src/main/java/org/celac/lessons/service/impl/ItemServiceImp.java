package org.celac.lessons.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.celac.lessons.component.CustomHttpClient;
import org.celac.lessons.models.Item;
import org.celac.lessons.service.ItemService;

import java.net.URI;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Logger;

public class ItemServiceImp implements ItemService {
    Logger logger = Logger.getLogger(ItemServiceImp.class.getName());
    private final URI uri = URI.create("https://api.restful-api.dev/objects");
    private static final ObjectMapper objectMapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);
    private final Function<HttpResponse,Optional<List<Item>>> bodyConverter = httpResponse -> {
        if (httpResponse.statusCode() == 200) {
            try {
                List<Item> items = objectMapper.readValue(httpResponse.body().toString(), new TypeReference<List<Item>>() {});
                return Optional.of(items);
            } catch (JsonProcessingException e) {
                logger.info(e.getMessage());
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
    };



    @Override
    public void loadAndConsumeItems(Consumer<Optional<List<Item>>> respConsumer) {
        CustomHttpClient.fetchPage(uri,bodyConverter,respConsumer).join();
    }
}
