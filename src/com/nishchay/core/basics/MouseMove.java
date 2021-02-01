package com.nishchay.core.basics;

import java.awt.Robot;
import java.util.Random;

public class MouseMove {

	private static final int TEN_SEC = 10000;
	private static final int MAX_X = 400;
	private static final int MAX_Y = 400;
	
	public static void main(String[] args) throws Exception{
		Robot robot =  new Robot();
		Random random = new Random();
		
		while(true){
			robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
			System.out.println("waiting .....");
			Thread.sleep(TEN_SEC);
		}

	}

}
