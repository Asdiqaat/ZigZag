import swiftbot.*;
import java.util.*;
public class Zigzag {
	static SwiftBotAPI swiftBot;
	static ZigzagMovement movement = new ZigzagMovement();
	static ScanQRCode qrScanner = new ScanQRCode();
	static AdditionalFunctions additionalFunc = new AdditionalFunctions();
	static UserInterface UI = new UserInterface();
	static Scanner sc = new Scanner (System.in);
	public static int ZigZagJourneys=0; //zigzag journeys
	public static int ZigZagLength;
	public static int ZigZagSections;

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
			System.out.println(UI.RED+"ERROR: Wrong button pressed.\n"+UI.RESET);
			UI.buttonAscii();
		});

		swiftBot.enableButton(Button.B, () -> {
			movement.configureColours();
			System.out.println("Colours changed successfully");
			System.out.println("Press Button A to start the journey");
			UI.buttonAscii();
		});

		swiftBot.enableButton(Button.Y, () -> {
			System.out.println("Button.Y pressed\nScan the QR Code");
			//qrScanner.scanQRCode();
			movement.ZigZag(20, 4, false); // Perform a zigzag movement
			movement.ZigZag(20, 4, true);
			UI.buttonAscii();
		});

		swiftBot.enableButton(Button.X, () -> {
			System.out.println("Exiting the program...");
			additionalFunc.underlight();
			swiftBot.disableAllButtons();
			UI.exit();
			System.exit(0);
		});

	}
}