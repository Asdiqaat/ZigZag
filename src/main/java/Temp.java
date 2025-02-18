import java.util.Random;
import swiftbot.*;
public class Temp {
	static SwiftBotAPI swiftBot;
	public static void main(String[] args) {
		try {
			swiftBot = new SwiftBotAPI();
		} catch (Exception e) {
			System.out.println("\nI2C disabled!");
			System.out.println("Run the following command:");
			System.out.println("sudo raspi-config nonint do_i2c 0\n");
			System.exit(5);
		}
		Zigzag50();
		//Zigzag100();
	}
	public static void Zigzag50() {
		int[] Colour1 = {0,255,0};
		int[] Colour2 = {0, 0, 255}; // Default blue
		int ZigzagLength = 20;
		int ZigzagSections = 4;
		Random random = new Random();
		int turnDistance = 13;
		int turnDistance2 = 8;
		int turnDistance3 = 18;
		//int randomSpeed = (random.nextInt(6)+5)*10; //multiply by 10
		int randomSpeed = 50;

		double actualSpeed =  randomSpeed == 100? 24.2:randomSpeed == 90? 23.6: randomSpeed == 80? 22.8:
			randomSpeed == 70? 21.6 : randomSpeed == 60? 19.6 : 17.6;

		double straightDuration = (ZigzagLength/actualSpeed);
		int straightDurationMs = (int)(straightDuration*1000);
		
		double turnDurationS = (turnDistance/actualSpeed);
		int turnDuration = (int)(turnDurationS*1000);

		double turnDurationS2 = (turnDistance2/actualSpeed);
		int turnDuration2 = (int)(turnDurationS2*1000);
		
		double turnDurationS3 = (turnDistance3/actualSpeed);
		int retraceTurn = (int)(turnDurationS3*1000);
		
		System.out.println("Random wheel speed = "+randomSpeed+" Distance = "+ZigzagLength+" Straight duration = "+straightDurationMs);
		System.out.println("STARTING THE ZIGZAG JOURNEY");

		for(int i=1; i<=ZigzagSections; i++) {
			if(i==1) {
				move(randomSpeed, 0, turnDuration2);
				//ZigZag.swiftBot.fillUnderlights(green);
				swiftBot.fillUnderlights(Colour1);
				move(randomSpeed, randomSpeed, straightDurationMs);
				System.out.println("ZigZag line: " + i+" of "+ZigzagSections);
			}
			else if(i%2==0) {
				swiftBot.fillUnderlights(Colour2);
				move(randomSpeed, -randomSpeed, turnDuration);
				move(randomSpeed, randomSpeed, straightDurationMs);
				System.out.println("ZigZag line: " + i+" of "+ZigzagSections);
			}else {
				swiftBot.fillUnderlights(Colour1);
				move(-randomSpeed, randomSpeed, turnDuration+200);
				move(randomSpeed, randomSpeed, straightDurationMs);
				System.out.println("ZigZag line: " + i+" of "+ZigzagSections);
			}
		}
		for(int i=1; i<=ZigzagSections; i++) {
			if(i==1) {
				move(randomSpeed, -randomSpeed, retraceTurn);
				swiftBot.fillUnderlights(Colour1);
				move(randomSpeed, randomSpeed, straightDurationMs);
				System.out.println("ZigZag line: " + i+" of "+ZigzagSections);
			}
			else if(i%2==0) {

				swiftBot.fillUnderlights(Colour1);
				move(-randomSpeed, randomSpeed, turnDuration+200);
				move(randomSpeed, randomSpeed, straightDurationMs);
				System.out.println("ZigZag line: " + i+" of "+ZigzagSections);
			}else {
				swiftBot.fillUnderlights(Colour2);
				move(randomSpeed, -randomSpeed, turnDuration);
				move(randomSpeed, randomSpeed, straightDurationMs);
				System.out.println("ZigZag line: " + i+" of "+ZigzagSections);
				
			}
		}
		swiftBot.disableUnderlights();
	}
	
	public static void Zigzag60() {
		int[] Colour1 = {0,255,0};
		int[] Colour2 = {0, 0, 255}; // Default blue
		int ZigzagLength = 20;
		int ZigzagSections = 4;
		Random random = new Random();
		int turnDistance = 13;
		int turnDistance2 = 8;
		//int randomSpeed = (random.nextInt(6)+5)*10; //multiply by 10
		int randomSpeed = 60;

		double actualSpeed =  randomSpeed == 100? 24.2:randomSpeed == 90? 23.6: randomSpeed == 80? 22.8:
			randomSpeed == 70? 21.6 : randomSpeed == 60? 19.6 : 17.6;

		double straightDuration = (ZigzagLength/actualSpeed);
		int straightDurationMs = (int)(straightDuration*1000);
		
		double turnDurationS = (turnDistance/actualSpeed);
		int turnDuration = (int)(turnDurationS*1000);
		
		double turnDurationS2 = (turnDistance2/actualSpeed);
		int turnDuration2 = (int)(turnDurationS2*1000);

		System.out.println("Random wheel speed = "+randomSpeed+" Distance = "+ZigzagLength+" Straight duration = "+straightDurationMs);
		System.out.println("STARTING THE ZIGZAG JOURNEY");

		for(int i=1; i<=ZigzagSections; i++) {
			if(i==1) {
				move(100, 0, 200);
				//ZigZag.swiftBot.fillUnderlights(green);
				swiftBot.fillUnderlights(Colour1);
				move(randomSpeed, randomSpeed, straightDurationMs);
				System.out.println("ZigZag line: " + i+" of "+ZigzagSections);
			}
			else if(i%2==0) {
				swiftBot.fillUnderlights(Colour2);
				move(randomSpeed, -randomSpeed, turnDuration);
				move(randomSpeed, randomSpeed, straightDurationMs);
				System.out.println("ZigZag line: " + i+" of "+ZigzagSections);
			}else {
				swiftBot.fillUnderlights(Colour1);
				move(-randomSpeed, randomSpeed, turnDuration+200);
				move(randomSpeed, randomSpeed, straightDurationMs);
				System.out.println("ZigZag line: " + i+" of "+ZigzagSections);
			}
		}
		swiftBot.disableUnderlights();
	}

	public static void Zigzag70() {
		int[] Colour1 = {0,255,0};
		int[] Colour2 = {0, 0, 255}; // Default blue
		int ZigzagLength = 20;
		int ZigzagSections = 4;
		Random random = new Random();
		int turnDistance2 = 8;
		int turnDistance = 13;
		//int randomSpeed = (random.nextInt(6)+5)*10; //multiply by 10
		int randomSpeed = 70;

		double actualSpeed =  randomSpeed == 100? 24.2:randomSpeed == 90? 23.6: randomSpeed == 80? 22.8:
			randomSpeed == 70? 21.6 : randomSpeed == 60? 19.6 : 17.6;

		double straightDuration = (ZigzagLength/actualSpeed);
		int straightDurationMs = (int)(straightDuration*1000);
		double turnDurationS = (turnDistance/actualSpeed);
		int turnDuration = (int)(turnDurationS*1000);
		
		double turnDurationS2 = (turnDistance2/actualSpeed);
		int turnDuration2 = (int)(turnDurationS2*1000);
		

		System.out.println("Random wheel speed = "+randomSpeed+" Distance = "+ZigzagLength+" Straight duration = "+straightDurationMs);
		System.out.println("STARTING THE ZIGZAG JOURNEY");

		for(int i=1; i<=ZigzagSections; i++) {
			if(i==1) {
				move(randomSpeed, 0, turnDuration2);
				//ZigZag.swiftBot.fillUnderlights(green);
				swiftBot.fillUnderlights(Colour1);
				move(randomSpeed, randomSpeed, straightDurationMs);
				System.out.println("ZigZag line: " + i+" of "+ZigzagSections);
			}
			else if(i%2==0) {
				swiftBot.fillUnderlights(Colour2);
				move(randomSpeed, -randomSpeed, turnDuration);
				move(randomSpeed, randomSpeed, straightDurationMs);
				System.out.println("ZigZag line: " + i+" of "+ZigzagSections);
			}else {
				swiftBot.fillUnderlights(Colour1);
				move(-randomSpeed, randomSpeed, turnDuration+200);
				move(randomSpeed, randomSpeed, straightDurationMs);
				System.out.println("ZigZag line: " + i+" of "+ZigzagSections);
			}
		}
		swiftBot.disableUnderlights();
	}
	
	public static void Zigzag80() {
		int[] Colour1 = {0,255,0};
		int[] Colour2 = {0, 0, 255}; // Default blue
		int ZigzagLength = 20;
		int ZigzagSections = 4;
		Random random = new Random();
		int turnDistance2 = 8;
		int turnDistance = 13;
		//int randomSpeed = (random.nextInt(6)+5)*10; //multiply by 10
		int randomSpeed = 80;

		double actualSpeed =  randomSpeed == 100? 24.2:randomSpeed == 90? 23.6: randomSpeed == 80? 22.8:
			randomSpeed == 70? 21.6 : randomSpeed == 60? 19.6 : 17.6;

		double straightDuration = (ZigzagLength/actualSpeed);
		int straightDurationMs = (int)(straightDuration*1000);
		double turnDurationS = (turnDistance/actualSpeed);
		int turnDuration = (int)(turnDurationS*1000);
		
		double turnDurationS2 = (turnDistance2/actualSpeed);
		int turnDuration2 = (int)(turnDurationS2*1000);
		

		System.out.println("Random wheel speed = "+randomSpeed+" Distance = "+ZigzagLength+" Straight duration = "+straightDurationMs);
		System.out.println("STARTING THE ZIGZAG JOURNEY");

		for(int i=1; i<=ZigzagSections; i++) {
			if(i==1) {
				move(randomSpeed, 0, turnDuration2);
				//ZigZag.swiftBot.fillUnderlights(green);
				swiftBot.fillUnderlights(Colour1);
				move(randomSpeed, randomSpeed, straightDurationMs);
				System.out.println("ZigZag line: " + i+" of "+ZigzagSections);
			}
			else if(i%2==0) {
				swiftBot.fillUnderlights(Colour2);
				move(randomSpeed, -randomSpeed, turnDuration);
				move(randomSpeed, randomSpeed, straightDurationMs);
				System.out.println("ZigZag line: " + i+" of "+ZigzagSections);
			}else {
				swiftBot.fillUnderlights(Colour1);
				move(-randomSpeed, randomSpeed, turnDuration+200);
				move(randomSpeed, randomSpeed, straightDurationMs);
				System.out.println("ZigZag line: " + i+" of "+ZigzagSections);
			}
		}
		swiftBot.disableUnderlights();
	}
	
	public static void Zigzag90() {
		int[] Colour1 = {0,255,0};
		int[] Colour2 = {0, 0, 255}; // Default blue
		int ZigzagLength = 20;
		int ZigzagSections = 4;
		Random random = new Random();
		int turnDistance2 = 8;
		int turnDistance = 13;
		//int randomSpeed = (random.nextInt(6)+5)*10; //multiply by 10
		int randomSpeed = 90;

		double actualSpeed =  randomSpeed == 100? 24.2:randomSpeed == 90? 23.6: randomSpeed == 80? 22.8:
			randomSpeed == 70? 21.6 : randomSpeed == 60? 19.6 : 17.6;

		double straightDuration = (ZigzagLength/actualSpeed);
		int straightDurationMs = (int)(straightDuration*1000);
		double turnDurationS = (turnDistance/actualSpeed);
		int turnDuration = (int)(turnDurationS*1000);
		
		double turnDurationS2 = (turnDistance2/actualSpeed);
		int turnDuration2 = (int)(turnDurationS2*1000);
		

		System.out.println("Random wheel speed = "+randomSpeed+" Distance = "+ZigzagLength+" Straight duration = "+straightDurationMs);
		System.out.println("STARTING THE ZIGZAG JOURNEY");

		for(int i=1; i<=ZigzagSections; i++) {
			if(i==1) {
				move(randomSpeed, 0, turnDuration2);
				//ZigZag.swiftBot.fillUnderlights(green);
				swiftBot.fillUnderlights(Colour1);
				move(randomSpeed, randomSpeed, straightDurationMs);
				System.out.println("ZigZag line: " + i+" of "+ZigzagSections);
			}
			else if(i%2==0) {
				swiftBot.fillUnderlights(Colour2);
				move(randomSpeed, -randomSpeed, turnDuration);
				move(randomSpeed, randomSpeed, straightDurationMs);
				System.out.println("ZigZag line: " + i+" of "+ZigzagSections);
			}else {
				swiftBot.fillUnderlights(Colour1);
				move(-randomSpeed, randomSpeed, turnDuration+200);
				move(randomSpeed, randomSpeed, straightDurationMs);
				System.out.println("ZigZag line: " + i+" of "+ZigzagSections);
			}
		}
		swiftBot.disableUnderlights();
	}
	
	public static void Zigzag100() {
		int[] Colour1 = {0,255,0};
		int[] Colour2 = {0, 0, 255}; // Default blue
		int ZigzagLength = 20;
		int ZigzagSections = 4;
		Random random = new Random();
		int turnDistance2 = 8;
		int turnDistance = 13;
		//int randomSpeed = (random.nextInt(6)+5)*10; //multiply by 10
		int randomSpeed = 100;

		double actualSpeed =  randomSpeed == 100? 24.2:randomSpeed == 90? 23.6: randomSpeed == 80? 22.8:
			randomSpeed == 70? 21.6 : randomSpeed == 60? 19.6 : 17.6;

		double straightDuration = (ZigzagLength/actualSpeed);
		int straightDurationMs = (int)(straightDuration*1000);
		double turnDurationS = (turnDistance/actualSpeed);
		int turnDuration = (int)(turnDurationS*1000);
		
		double turnDurationS2 = (turnDistance2/actualSpeed);
		int turnDuration2 = (int)(turnDurationS2*1000);
		

		System.out.println("Random wheel speed = "+randomSpeed+" Distance = "+ZigzagLength+" Straight duration = "+straightDurationMs);
		System.out.println("STARTING THE ZIGZAG JOURNEY");

		for(int i=1; i<=ZigzagSections; i++) {
			if(i==1) {
				move(randomSpeed, 0, turnDuration2);
				//ZigZag.swiftBot.fillUnderlights(green);
				swiftBot.fillUnderlights(Colour1);
				move(randomSpeed, randomSpeed, straightDurationMs);
				System.out.println("ZigZag line: " + i+" of "+ZigzagSections);
			}
			else if(i%2==0) {
				swiftBot.fillUnderlights(Colour2);
				move(randomSpeed, -randomSpeed, turnDuration);
				move(randomSpeed, randomSpeed, straightDurationMs);
				System.out.println("ZigZag line: " + i+" of "+ZigzagSections);
			}else {
				swiftBot.fillUnderlights(Colour1);
				move(-randomSpeed, randomSpeed, turnDuration+200);
				move(randomSpeed, randomSpeed, straightDurationMs);
				System.out.println("ZigZag line: " + i+" of "+ZigzagSections);
			}
		}
		swiftBot.disableUnderlights();
	}
	
	private static void move(int LeftWheelSpeed, int RightWheelSpeed, int duration) {
		try {
			Thread.sleep(500);
			swiftBot.move(LeftWheelSpeed, RightWheelSpeed, duration);

		}
		catch (Exception e) {
			System.out.println("Error moving Swiftbot: " + e.getMessage());
		}
	}
}

