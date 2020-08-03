package com.mike;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGeneratorImpl implements NumberGenerator
{
	@Getter
	private final int minNumber;

	@Getter
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
}
