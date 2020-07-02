package com.mike;

public interface Game
{
	int getNumber();

	int getGuess();

	void setGuess(int guess);

	int getSmallest();

	int getBiggest();

	int getRemainingGuesses();

	int getGuessCount();

	void reset();

	void check();

	boolean isValidNumber();

	boolean isGameWon();

	boolean isGameLost();
}
