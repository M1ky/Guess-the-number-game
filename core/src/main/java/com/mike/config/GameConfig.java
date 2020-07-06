package com.mike.config;

import com.mike.GuessCount;
import com.mike.MaxNumber;
import com.mike.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.mike")
@PropertySource("classpath:config/game.properties")
public class GameConfig
{
	@Value("${game.minNumber}")
	private int minNumber;

	@Value("${game.maxNumber}")
	private int maxNumber;

	@Value("${game.guessCount}")
	private int guessCount;


	@Bean
	@MinNumber
	public int minNumber()
	{
		return minNumber;
	}

	@Bean
	@MaxNumber
	public int maxNumber()
	{
		return maxNumber;
	}

	@Bean
	@GuessCount
	public int guessCount()
	{
		return guessCount;
	}
}
