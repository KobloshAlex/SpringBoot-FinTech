package com.github.kobloshalex.fintech.domain.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MessagingConst {
  TOPIC("userRegisteredTopic"),
  QUEUE_NAME("user.registered"),
  ROUTING_KEY("user.#");

  private final String message;
}
