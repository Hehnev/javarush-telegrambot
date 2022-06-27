package com.github.hehnev.telegrambot.jrtb.command;

import com.github.hehnev.telegrambot.jrtb.command.Command;
import com.github.hehnev.telegrambot.jrtb.command.CommandContainer;
import com.github.hehnev.telegrambot.jrtb.command.CommandName;
import com.github.hehnev.telegrambot.jrtb.command.UnknownCommand;
import com.github.hehnev.telegrambot.jrtb.service.SendBotMessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

@DisplayName("Unit-level testing for CommandContainer")
public class CommandContainerTest {

    private CommandContainer commandContainer;

    @BeforeEach
    public void init() {
        SendBotMessageService service = Mockito.mock(SendBotMessageService.class);
        commandContainer = new CommandContainer(service);
    }

    @Test
    public void shouldGetAllTheExistingCommands() {
        Arrays.stream(CommandName.values())
                .forEach(commandName -> {
                    Command command = commandContainer.retrieveCommand(commandName.getCommandName());
                    Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
                });
    }

    @Test
    public void shouldReturnUnknownCommand() {
        String unknownCommand = "/jlakdjflak";

        Command command = commandContainer.retrieveCommand(unknownCommand);

        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }
}
