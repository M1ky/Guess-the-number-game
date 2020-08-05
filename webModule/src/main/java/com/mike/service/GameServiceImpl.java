package com.mike.service;

import com.mike.Game;
import com.mike.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class GameServiceImpl implements GameService
{
	private Game game;
	private MessageGenerator messageGenerator;

	@Autowired
	public GameServiceImpl(Game game, MessageGenerator messageGenerator)
	{
		this.game = game;
		this.messageGenerator = messageGenerator;
	}

	@PostConstruct
	public void init()
	{
		log.info("GameServiceImpl, goal = {}", game.getNumber());
	}

	@Override
	public boolean isGameOver()
	{
		return game.isGameLost() || game.isGameWon();
	}

	@Override
	public String getMainMessage()
	{
		return messageGenerator.getMainMessage();
	}

	@Override
	public String getResultMessage()
	{
		return messageGenerator.getResultMessage();
	}

	@Override
	public void checkGuess(int guess)
	{
		game.setGuess(guess);
		game.check();
	}

	@Override
	public void reset()
	{
		game.reset();
	}
}
