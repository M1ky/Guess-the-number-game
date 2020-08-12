package com.mike;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator
{
	private final Game game;


	@Autowired
	public MessageGeneratorImpl(Game game)
	{
		this.game = game;
	}

	@PostConstruct
	public void init()
	{
		log.info("game = " + game);
	}

	@Override
	public String getMainMessage()
	{
		return "Number is between " + game.getSmallest()
				 + " and " + game.getBiggest();
	}

	@Override
	public String getResultMessage()
	{
		if (game.isGameWon())
			return "Congrats, the number was: " + game.getNumber();
		else if (game.isGameLost())
			return "Aww you just lost, the number was: " + game.getNumber();
		else if (!game.isValidNumber())
			return "The guess is not in valid range";
		else if (game.getRemainingGuesses() == game.getGuessCount())
			return "What is your first guess?";
		else
		{
			String direction;
			if (game.getGuess() < game.getNumber())
				direction = "higher";
			else
				direction = "lower";

			return direction + "\nYou have: " + game.getRemainingGuesses() + " guesses left";
		}
	}
}
