package com.github.kobloshalex.profile.config;

import com.github.kobloshalex.profile.event.UserRegisterEventHandler;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
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
  public Binding setBinding(Queue queue, TopicExchange topicExchange) {
    return BindingBuilder.bind(queue)
        .to(topicExchange)
        .with(MessagingConst.ROUTING_KEY.getMessage());
  }

  @Bean
  public MessageListenerAdapter messageListenerAdapter(UserRegisterEventHandler eventHandler) {
    return new MessageListenerAdapter(eventHandler, "handleUserRegister");
  }

  @Bean
  public SimpleMessageListenerContainer container(
      ConnectionFactory connectionFactory, MessageListenerAdapter messageListenerContainer) {
    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    container.setConnectionFactory(connectionFactory);
    container.setQueueNames(MessagingConst.QUEUE_NAME.getMessage());
    container.setMessageListener(messageListenerContainer);

    return container;
  }
}
