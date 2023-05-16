package com.kriss.com.kriss.newVersion.commands;

import org.springframework.stereotype.Component;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import reactor.core.publisher.Mono;

@Component
public class ShutdownCommand implements SlashCommands {
    
	@Override
    public String getName() {
        return "shutdown";
    }

    @Override
    public Mono<Void> handle(ChatInputInteractionEvent event) {
    	
    	System.out.println("Bot schaltet sich aus!");
    	event.reply()
            .withEphemeral(true)
            .withContent("Bot schaltet sich aus!");
    	System.exit(0);
    	
    	return event.reply();
    }

}
