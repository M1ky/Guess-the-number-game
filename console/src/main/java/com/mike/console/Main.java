package com.mike.console;


import com.mike.AppConfig;
import com.mike.Game;
import com.mike.MessageGenerator;
import com.mike.NumberGenerator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
	private static final Logger log = LogManager.getLogger(Main.class);

	public static void main(String[] args)
	{
		log.info("Guess the number game");

		// create context (container)
//		use class as configuration
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//		use xml file as configuration
//		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		NumberGenerator gen = context.getBean("numberGenerator", NumberGenerator.class);

		int number = gen.next();
		log.info("number = " + number);

		Game game = context.getBean(Game.class);
		game.reset();
		log.info("game = " + game);


		MessageGenerator msgGenerator = context.getBean(MessageGenerator.class);
		log.info("getMainMessage() = " + msgGenerator.getMainMessage());
		log.info("getResultMessage() = " + msgGenerator.getResultMessage());
		// close context (container)
		context.close();
	}
}
