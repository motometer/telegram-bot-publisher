package org.motometer.bot.telegram.api;

import lombok.RequiredArgsConstructor;
import org.motometer.telegram.bot.Bot;
import org.motometer.telegram.bot.UpdateListener;
import org.motometer.telegram.bot.api.Update;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageSender implements UpdateListener {

    private final Bot bot;
    private final OutboundMessageFactory outboundMessageFactory;

    @Override
    @KafkaListener(topics = "${telegram.output.topic}", groupId = "1")
    public void onUpdate(Update update) {
        var message = outboundMessageFactory.createMessage(update.getMessage().getChat().getId());
        bot.sendMessage(message);
    }
}
