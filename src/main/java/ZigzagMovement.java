import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Scanner;
public class ZigzagMovement {
	private static final String blue = "\u001B[38;5;33m",RESET = "\u001B[0m",red="\u001B[38;5;160m";
	private int[] Colour1 = {0, 255, 0}; // Default green
	private int[] Colour2 = {0, 0, 255}; // Default blue
	static Scanner sc = new Scanner(System.in);
	static AdditionalFunctions additionalFunc = new AdditionalFunctions();
	static UserInterface UI = new UserInterface();
	public void scanQRCode() {
		long startTime = System.currentTimeMillis();
		long endTime = startTime + 20000; // 10 seconds in milliseconds
		int []purple = {143, 67, 230}; 
		int[] red = {255,0,0};
		int[] yellow = {255,250,0};
		System.out.println("Starting 20s timer");
		UI.ScanningUI();
		try {
			while (System.currentTimeMillis() < endTime) {
				Zigzag.swiftBot.fillUnderlights(yellow);

				BufferedImage img = Zigzag.swiftBot.getQRImage();
				String decodedMessage = Zigzag.swiftBot.decodeQRImage(img);

				if (decodedMessage.isEmpty()) {
					UI.unsuccessfulUI();
					Zigzag.swiftBot.fillUnderlights(red);
				} else {
					UI.successUI();
					Zigzag.swiftBot.fillUnderlights(purple);
					Thread.sleep(1000);
					if(validateDecodedMessage(decodedMessage)) {
						System.out.println("Checking if the code entered is valid");
						Thread.sleep(250);
						UI.validUI();
						Zigzag.swiftBot.fillUnderlights(purple);
						int ZigzagLength = Integer.parseInt(decodedMessage.substring(0, decodedMessage.indexOf(":")));
						int ZigzagSections = Integer.parseInt(decodedMessage.substring(decodedMessage.indexOf(":") + 1));
						System.out.println("Decoded message -> Zigzag Length => "+ZigzagLength + " Zigzag Sections => "+ZigzagSections);
						System.out.println("Set the SwiftBot to start the Zigzag journey");
						Thread.sleep(3000);
						ZigZag(ZigzagLength,ZigzagSections);
					}
					else{
						UI.invalidUI();
						Zigzag.swiftBot.fillUnderlights(yellow);
					}
					break;
				}

				System.out.println("Time elapsed: " + (System.currentTimeMillis() - startTime) / 1000.0 + " seconds");
				Thread.sleep(5000);//5 seconds
			}
			Zigzag.swiftBot.disableUnderlights();
			System.out.println("Loop finished!");

		} catch (Exception e) {
			System.out.println(red+"ERROR: Unable to scan for code."+RESET);
			e.printStackTrace();
			System.exit(5);
		}
	}

	private boolean validateDecodedMessage (String message) {
		try {
			int ZigzagLength=Integer.parseInt(message.substring(0, message.indexOf(":")));
			int ZigzagSections=Integer.parseInt(message.substring(message.indexOf(":")+1));

			if((ZigzagLength>=15 && ZigzagLength <=85) && (ZigzagSections<=12 && ZigzagSections%2==0)) {
				System.out.println("The decoded message is valid");
				return true;
			}
		}catch (Exception e) {
			System.out.println("ERROR: The values entered are invalid");
		}
		return false;
	}

	public void ZigZag(int ZigzagLength, int ZigzagSections) {
		Random random = new Random();
		int turnSpeed = 100; // Speed for turning
		int turnDuration =450; // Duration in milliseconds for a 150-degree turn (adjust as needed)
		int randomSpeed = (random.nextInt(6)+5)*10; //multiply by 10
		
		double actualSpeed =  randomSpeed == 100? 24.2:randomSpeed == 90? 22.6:randomSpeed == 80? 20.0:
							  randomSpeed == 70? 18.4 : randomSpeed == 60? 16.8 : 15.2;
		
		double straightDuration = (ZigzagLength/actualSpeed);
		int straightDurationMs = (int)(straightDuration*1000);

		System.out.println(blue+"Random wheel speed = "+randomSpeed+" Distance = "+ZigzagLength+" Straight duration = "+straightDurationMs+RESET);
		System.out.println("STARTING THE ZIGZAG JOURNEY");

		for(int i=1; i<=ZigzagSections; i++) {
			if(i==1) {
				move(100, 0, 100);
				//ZigZag.swiftBot.fillUnderlights(green);
				Zigzag.swiftBot.fillUnderlights(Colour1);
				additionalFunc.Ultrasound(ZigzagLength);
				move(randomSpeed, randomSpeed, straightDurationMs);
				System.out.println(blue+"ZigZag line: " + i+" of "+ZigzagSections);
			}
			else if(i%2==0) {
				//ZigZag.swiftBot.fillUnderlights(blue);
				Zigzag.swiftBot.fillUnderlights(Colour2);
				move(turnSpeed, -turnSpeed, turnDuration);
				additionalFunc.Ultrasound(ZigzagLength);
				move(randomSpeed, randomSpeed, straightDurationMs);
				System.out.println(blue+"ZigZag line: " + i+" of "+ZigzagSections+RESET);
			}else {
				//ZigZag.swiftBot.fillUnderlights(green);
				Zigzag.swiftBot.fillUnderlights(Colour1);
				move(-turnSpeed, turnSpeed, turnDuration);
				additionalFunc.Ultrasound(ZigzagLength);
				move(randomSpeed, randomSpeed, straightDurationMs);
				System.out.println(blue+"ZigZag line: " + i+" of "+ZigzagSections+RESET);
			}
		}
		Zigzag.swiftBot.disableUnderlights();
	}
	
	private static void move(int LeftWheelSpeed, int RightWheelSpeed, int duration) {
		try {
			Zigzag.swiftBot.move(LeftWheelSpeed, RightWheelSpeed, duration);
			Thread.sleep(500);
		}
		catch (Exception e) {
			System.out.println(red+"Error moving Swiftbot: " + e.getMessage()+RESET);
		}
	}
}