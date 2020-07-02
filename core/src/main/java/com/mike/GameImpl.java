package com.mike;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class GameImpl implements Game
{
	@Autowired
	private NumberGenerator numberGenerator;

	@Autowired
	private int guessCount;

	private static final Logger log = LogManager.getLogger(GameImpl.class);
	private int number;
	private int guess;
	private int smallest;
	private int biggest;
	private int remainingGuesses;
	private boolean validNumberRange = true;

	@Override
	@PostConstruct
	public void reset()
	{
		smallest = 0;
		guess = 0;
		remainingGuesses = guessCount;
		biggest = numberGenerator.getMaxNumber();
		number = numberGenerator.next();
		log.debug("The number is: " + number);
	}

	@PreDestroy
	public void preDestroy()
	{
		log.info("in Game preDestroy()");
	}

	@Override
	public int getNumber()
	{
		return number;
	}

	@Override
	public int getGuess()
	{
		return guessCount;
	}

	@Override
	public void setGuess(int guess)
	{
		this.guess = guess;
	}

	@Override
	public int getSmallest()
	{
		return smallest;
	}

	@Override
	public int getBiggest()
	{
		return biggest;
	}

	@Override
	public int getRemainingGuesses()
	{
		return remainingGuesses;
	}

	@Override
	public int getGuessCount()
	{
		return guessCount;
	}

	@Override
	public void check()
	{
		checkValidNumberRange();

		if (validNumberRange)
		{
			if (guess > number)
			{
				biggest = guess - 1;
			}

			if (guess < number)
			{
				smallest = guess + 1;
			}
		}

		remainingGuesses--;
	}

	@Override
	public boolean isValidNumber()
	{
		return validNumberRange;
	}

	@Override
	public boolean isGameWon()
	{
		return guess == number;
	}

	@Override
	public boolean isGameLost()
	{
		return !isGameWon() && remainingGuesses <= 0;
	}

	private void checkValidNumberRange()
	{
		validNumberRange = (guess >= smallest) && (guess <= biggest);
	}
}
