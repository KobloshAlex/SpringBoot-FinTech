package com.github.kobloshalex.profile.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MessagingConst {
  TOPIC("userRegisteredTopic"),
  QUEUE_NAME("user.registered.profile"),
  ROUTING_KEY("user.#");

  private final String message;
}
