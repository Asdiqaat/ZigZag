import java.util.Random;
import java.util.Scanner;
public class ZigzagMovement {
	private int[] Colour1 = {0, 255, 0}; // Default green
	private int[] Colour2 = {0, 0, 255}; // Default blue
	static Scanner sc = new Scanner(System.in);
	static AdditionalFunctions additionalFunc = new AdditionalFunctions();
	static UserInterface UI = new UserInterface();


	public void ZigZag(int ZigzagLength, int ZigzagSections, boolean isRetrace) {
		Random random = new Random();
		int randomSpeed = (random.nextInt(6)+5)*10; //multiply by 10

		double actualSpeed =  randomSpeed == 100? 24.2:randomSpeed == 90? 23.6: randomSpeed == 80? 22.8:
			randomSpeed == 70? 21.6 : randomSpeed == 60? 19.6 : 17.6;

		double straightDurationS = (ZigzagLength/actualSpeed);
		int straightDuration = (int)(straightDurationS*1000);
		
		System.out.println(UI.BLUE+"Random wheel speed = "+randomSpeed+" Distance = "+ZigzagLength+UI.RESET);
		System.out.println("STARTING THE ZIGZAG JOURNEY");
		long startTime = System.currentTimeMillis();
		
		for(int i=1; i<=ZigzagSections; i++) {
			if(i==1) {
				int initialLS = isRetrace? 80 : 80; //Initial left wheel speed
				int initialRS = isRetrace? 80:0; //initial right wheel speed
				int duration = isRetrace? 790 : 350; //duration
				
				Zigzag.swiftBot.fillUnderlights(Colour1);
				move(initialLS,initialRS,duration);
				additionalFunc.Ultrasound(ZigzagLength);
				move(randomSpeed, randomSpeed, straightDuration);
				System.out.println(UI.BLUE+"ZigZag line: " + i+" of "+ZigzagSections);
			}
			else {
				boolean isEven = (i%2 == 0);
				Zigzag.swiftBot.fillUnderlights(isEven? Colour2 : Colour1);

				//RETRACE
				int leftWheelSpeed = isRetrace? (isEven? -80 : 80) : (isEven? 80: -80);
				int rightWheelSpeed = isRetrace? (isEven? 80 : -80) : (isEven? -80: 80);

				move(leftWheelSpeed, rightWheelSpeed, 530);

				additionalFunc.Ultrasound(ZigzagLength);
				move(randomSpeed, randomSpeed, straightDuration);
				System.out.println(UI.BLUE + "ZigZag line: " + i + " of " + ZigzagSections + UI.RESET);
			}
		}
		long endTime = System.currentTimeMillis();
		int totalLength = ZigzagLength * ZigzagSections;
		long totalTimeTaken = (endTime - startTime)/1000;
		Zigzag.swiftBot.disableUnderlights();
	}

	private static void move(int LeftWheelSpeed, int RightWheelSpeed, int duration) {
		try {
			Zigzag.swiftBot.move(LeftWheelSpeed, RightWheelSpeed, duration);
			Thread.sleep(1000);

		}
		catch (Exception e) {
			System.out.println(UI.RED+"Error moving Swiftbot: " + e.getMessage()+UI.RESET);
		}
	}

	public void configureColours() {
		UI.colourUI();
		String choice = sc.nextLine();
		switch (choice) {
		case "1":
			Colour1 = new int[]{255,0,0}; // red
			Colour2 = new int[]{0, 255, 0}; // green
			break;
		case "2":
			Colour1 = new int[]{255, 105, 180}; // Pink
			Colour2 = new int[]{242, 250, 92}; // yellow
			break;
		case "3":
			Colour1 = new int[]{116, 36, 166}; //  purple
			Colour2 = new int[]{152, 255, 152}; // Mint
			break;
		case "4":
			Colour1 = new int[]{153, 195, 240}; // sky blue
			Colour2 = new int[]{255, 165, 0}; // orange
			break;
		default:
			Colour1 = new int[]{0, 255, 0}; // Default green
			Colour2 = new int[]{0, 0, 255}; // Default blue
			System.out.println("Using default colors (Green and Blue).");
		}
	}

}