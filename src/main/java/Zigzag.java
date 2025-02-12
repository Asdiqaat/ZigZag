import swiftbot.*;
import java.util.*;
public class Zigzag {
	static SwiftBotAPI swiftBot;
	static ZigzagMovement qrScanner = new ZigzagMovement();
	static AdditionalFunctions additionalFunc = new AdditionalFunctions();
	static UserInterface UI = new UserInterface();
	static Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		try {
			swiftBot = new SwiftBotAPI();
		} catch (Exception e) {
			System.out.println("\nI2C disabled!");
			System.out.println("Run the following command:");
			System.out.println("sudo raspi-config nonint do_i2c 0\n");
			System.exit(5);
		}
		UI.ZigzagAscii();
		buttonReturn();
	}
	public static void buttonReturn () {
		UI.buttonAscii();
	    swiftBot.enableButton(Button.A, () -> {
	        //qrScanner.scanQRCode(); // Scan a QR code
	    	qrScanner.ZigZag(20, 4); // Perform a zigzag movement
	        System.out.println("QR Code scanning completed.");
	    });

	    swiftBot.enableButton(Button.B, () -> {
	    	additionalFunc.configureColors();
	        System.out.println("Colours changed successfully");
	        System.out.println("Press Button A to start the journey");
	    });

	    swiftBot.enableButton(Button.Y, () -> {
	    	System.out.println("Invalid button pressed");
	    });

	    swiftBot.enableButton(Button.X, () -> {
	        System.out.println("Exiting the program...");
	        additionalFunc.underlight();
	        swiftBot.disableAllButtons();
	        System.exit(0);
	    });
	        
	}
}