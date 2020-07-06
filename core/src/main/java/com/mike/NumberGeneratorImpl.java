package com.mike;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator
{
	@Autowired
	@MinNumber
	private int minNumber;

	@Autowired
	@MaxNumber
	private int maxNumber;

	private final Random random = new Random();

	@Override
	public int next()
	{
		return random.nextInt(maxNumber-minNumber) + minNumber;
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
