package com.mike;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator
{
	@Autowired
	private Game game;

	private Logger logger = new LogManager().getLogger(MessageGeneratorImpl.class);
	private int guessCount = 10;

	@PostConstruct
	public void init()
	{
		logger.info("game = " + game);
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
			return "Congrats";
		else if (game.isGameLost())
			return "Aww you just lost.";
		else if (!game.isValidNumber())
			return "The guess is not in valid range";
		else if (game.getRemainingGuesses() == guessCount)
			return "What is your first guess";
		else
		{
			String direction = "lower";
			if (game.getGuess() < game.getNumber())
				direction = "higher";

			return direction + "\nYou have: " + game.getRemainingGuesses() + " guesses left";
		}
	}
}
