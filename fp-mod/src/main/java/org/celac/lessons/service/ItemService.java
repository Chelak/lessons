package org.celac.lessons.service;

import org.celac.lessons.models.Item;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public interface ItemService {
  void loadAndConsumeItems(Consumer<Optional<List<Item>>> respConsumer);
}
