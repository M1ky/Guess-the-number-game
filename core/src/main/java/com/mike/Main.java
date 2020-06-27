package com.mike;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Main
{
	private static final Logger log = LogManager.getLogger(Main.class);

	public static void main(String[] args)
	{
		log.info("Hello, world");
		log.debug("debug");
	}
}
