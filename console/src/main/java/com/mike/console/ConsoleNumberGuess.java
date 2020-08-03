package com.mike.console;

import com.mike.Game;
import com.mike.MessageGenerator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleNumberGuess
{
	private static final Logger log = LogManager.getLogger(ConsoleNumberGuess.class);

	private final Game game;
	private final MessageGenerator msgGenerator;

	@Autowired
	public ConsoleNumberGuess(Game game, MessageGenerator msgGenerator)
	{
		this.game = game;
		this.msgGenerator = msgGenerator;
	}

	@EventListener(ContextRefreshedEvent.class)
	public void start()
	{
		Scanner scanner = new Scanner(System.in);

		while (true)
		{
			System.out.println(msgGenerator.getMainMessage());
			System.out.println(msgGenerator.getResultMessage());

			int guess = scanner.nextInt();
			scanner.nextLine();

			game.setGuess(guess);
			game.check();

			if (game.isGameWon() || game.isGameLost())
			{
				System.out.println(msgGenerator.getResultMessage());
				System.out.println("Play again y/n?");

				String playAgainString = scanner.nextLine().trim();
				if (!playAgainString.equalsIgnoreCase("y"))
					break;

				game.reset();
			}
		}
	}


	/*
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
	{
		log.info("Container ready for use: " + ConsoleNumberGuess.class + ".onApplicationEvent()");
	}

	@EventListener
	public void anotherWayOnApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
	{
		log.info("Container ready for use: " + ConsoleNumberGuess.class + ".anotherWayOnApplicationEvent()");
	}

	@EventListener(ContextRefreshedEvent.class)
	public void yetAnotherWayOnApplicationEvent()
	{
		log.info("Container ready for use: " + ConsoleNumberGuess.class + ".yetAnotherWayOnApplicationEvent()");
	}
	*/
}
