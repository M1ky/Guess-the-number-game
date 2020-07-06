package com.mike.console;


import com.mike.config.GameConfig;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main
{
	private static final Logger log = LogManager.getLogger(Main.class);

	public static void main(String[] args)
	{
		log.info("Guess the number game");

		// create context (container)
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);

		// close context (container)
		context.close();
	}
}
