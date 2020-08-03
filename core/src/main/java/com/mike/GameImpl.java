package com.mike;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Getter
@Component
public class GameImpl implements Game
{
	private static final Logger log = LogManager.getLogger(GameImpl.class);

	@Getter(AccessLevel.NONE)
	private final NumberGenerator numberGenerator;
	private final int guessCount;

	private int number;
	private int smallest;
	private int biggest;
	private int remainingGuesses;
	private boolean validNumberRange = true;

	@Setter
	private int guess;


	@Autowired
	public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount)
	{
		this.numberGenerator = numberGenerator;
		this.guessCount = guessCount;
	}

	@Override
	@PostConstruct
	public void reset()
	{
		guess = 0;
		remainingGuesses = guessCount;
		smallest = numberGenerator.getMinNumber();
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
			remainingGuesses--;
		}
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
