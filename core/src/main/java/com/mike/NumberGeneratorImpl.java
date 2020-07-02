package com.mike;

import org.springframework.stereotype.Component;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator
{
	private final Random random = new Random();
	private int maxNumber = 100;

	@Override
	public int next()
	{
		return random.nextInt(maxNumber);
	}

	@Override
	public int getMaxNumber()
	{
		return maxNumber;
	}
}
