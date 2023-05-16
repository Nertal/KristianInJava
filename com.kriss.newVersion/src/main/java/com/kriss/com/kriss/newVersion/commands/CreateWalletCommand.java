package com.kriss.com.kriss.newVersion.commands;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import discord4j.core.object.entity.User;
import discord4j.core.GatewayDiscordClient;

@Component
public class CreateWalletCommand implements SlashCommands {
    @Override
    public String getName() {
        return "createwallet";
    }

	@Override
	public Mono<Void> handle(ChatInputInteractionEvent event) {
		Flux<User> DiscordUser = event.getClient().getUsers();
		
		

	        return event.reply()
	            .withEphemeral(true)
	            .withContent(AddUserToWalletList(DiscordUser.toString()));
	}
	
	private String AddUserToWalletList(String UserID)
	{
	
		String returnString = "Irgendwas ist wohl schief gelaufen";
		try {
			File myFile = new File("UserList.txt");
			myFile.createNewFile(); // if file already exists will do nothing 
			FileInputStream inputStream = new FileInputStream(myFile);
			
			if(inputStream.toString().contains(UserID))
			{
				returnString = "Wallet existiert bereits!";
			}
			else
			{
				inputStream.toString().concat(UserID);
				returnString = "Wallet wurde erstellt!";
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return returnString;
	}
}
