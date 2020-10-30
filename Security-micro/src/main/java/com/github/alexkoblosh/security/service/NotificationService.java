package com.github.alexkoblosh.security.service;

import com.github.alexkoblosh.security.config.MessagingConst;
import com.github.alexkoblosh.security.dto.UserDto;
import com.github.alexkoblosh.security.user.User;
import com.google.gson.Gson;
import org.dom4j.util.UserDataAttribute;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {

  private final RabbitTemplate rabbitTemplate;
  private final Gson gson;

  public NotificationService(RabbitTemplate rabbitTemplate, Gson gson) {
    this.rabbitTemplate = rabbitTemplate;
    this.gson = gson;
  }

  public void sendMessage(UserDto userDto) {
    userDto.setPassword(null);
    rabbitTemplate.convertAndSend(
        MessagingConst.TOPIC.getMessage(),
        MessagingConst.QUEUE_NAME.getMessage(),
        gson.toJson(userDto));
  }
}
