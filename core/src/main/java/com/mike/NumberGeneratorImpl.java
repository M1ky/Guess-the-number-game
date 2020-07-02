package com.mike;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator
{
	@Autowired
	private int maxNumber;

	private final Random random = new Random();

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
