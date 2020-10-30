package com.github.alexkoblosh.security.config;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

  @Bean
  public Queue userRegisteredQueue() {
    return new Queue(MessagingConst.QUEUE_NAME.getMessage(), false);
  }

  @Bean
  public TopicExchange userRegisteredTopic() {
    return new TopicExchange(MessagingConst.TOPIC.getMessage());
  }

  @Bean
  public ConnectionFactory connectionFactory() {
    return new ConnectionFactory();
  }

  @Bean
  public Binding setBinding(Queue queue, TopicExchange topicExchange) {
    return BindingBuilder.bind(queue).to(topicExchange).with(MessagingConst.ROUTING_KEY.getMessage());
  }
}
