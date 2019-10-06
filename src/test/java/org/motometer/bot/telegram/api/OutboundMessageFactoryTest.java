package org.motometer.bot.telegram.api;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OutboundMessageFactoryTest {

    @Test
    void createMessage() {
        var factory = new OutboundMessageFactory();
        var chatId = 321;

        var message = factory.createMessage(chatId);

        assertThat(message).isNotNull();
        assertThat(message.chatId()).isEqualTo(chatId);
        assertThat(message.text()).isEqualTo("Your message was accepted");
    }
}