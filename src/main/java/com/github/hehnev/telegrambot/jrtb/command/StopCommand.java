package com.github.hehnev.telegrambot.jrtb.command;

import com.github.hehnev.telegrambot.jrtb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Stop {@link Command}.
 */
public class StopCommand implements Command{

    public final static String STOP_MESSAGE = "Деактивировал все ваши подписки \uD83D\uDE1F.";

    private final SendBotMessageService sendBotMessageService;

    public StopCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
    }
}
