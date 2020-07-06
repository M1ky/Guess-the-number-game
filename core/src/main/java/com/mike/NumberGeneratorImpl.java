package com.mike;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGeneratorImpl implements NumberGenerator
{
	private final int minNumber;
	private final int maxNumber;

	private final Random random = new Random();

	@Autowired
	public NumberGeneratorImpl(@MinNumber int minNumber, @MaxNumber int maxNumber)
	{
		this.minNumber = minNumber;
		this.maxNumber = maxNumber;
	}

	@Override
	public int next()
	{
		return random.nextInt(maxNumber - minNumber) + minNumber;
	}

	@Override
	public int getMinNumber()
	{
		return minNumber;
	}

	@Override
	public int getMaxNumber()
	{
		return maxNumber;
	}
}
