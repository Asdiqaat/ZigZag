public class UserInterface {
	public static final String CREAM = "\u001B[38;5;11m",CYAN = "\u001B[38;5;153m",YELLOW="\u001B[38;5;227m",PURPLE ="\u001B[38;5;177m";
	public static final String RESET = "\u001B[0m",RED="\u001B[38;5;160m",COMBINED_COLOUR2 = "\u001B[38;5;17m\u001B[48;5;15m";
	public static final String GREEN = "\u001B[38;5;2m",BLUE = "\u001B[38;5;33m", PINK ="\u001B[38;5;169m";
	public static final String MINT="\u001B[38;5;157m",ORANGE="\u001B[38;5;209m";

	public void ZigzagAscii() {
		String[] asciiArt = {
				"    *             *            *             *             * ",
				"    \\"+"\\          //\\"+"\\          //\\"+"\\          //\\"+"\\          // ",
				"     \\"+"\\        //  \\"+"\\        //  \\"+"\\        //  \\"+"\\        //  ",
				"      \\"+"\\      //    \\"+"\\      //    \\"+"\\      //    \\"+"\\      //   ",
				"       \\"+"\\    //      \\"+"\\    //      \\"+"\\    //      \\"+"\\    //    ",
				"        \\"+"\\  //        \\"+"\\  //        \\"+"\\  //        \\"+"\\  //     ",
				"         \\"+"\\//          \\"+"\\//          \\"+"\\//          \\"+"\\//      ",
				"          *             *             *             *        ",
		};
		System.out.println();
		for (String line : asciiArt) {
			System.out.println(COMBINED_COLOUR2+line+RESET);
		}
		//welcome message 
		System.out.println("\rWelcome to the SwiftBot Zigzag Path Program!\r\n"
				+ "This program will make the SwiftBot move in a zigzag pattern based on your input.\r\n"
				+ "Press Button Y to scan the QR code\r\n"
				+ "The QR code must contain two values (length of a section and number of sections)\r\n"
				+ "In the format: Value_1:Value_2.\r\n"
				+ "\nPress Button B to customise colours the SwiftBot should display while traversing the given path.\r\n"
				+ "There are four pairs of colours you can choose from.\r\n"
				+ "Enter a number to save the choice of colours\r\n"
				+ "\nPress Button X to view record of journey\n"
				+ "Pressing Button X will quit the program\n"
				+"\n");
	}

	public void buttonAscii() {
		String[]press = {""
				+ "  ___                        ___      _   _            \r\n"
				+ " | _ \\_ _ ___ ______  __ _  | _ )_  _| |_| |_ ___ _ _  \r\n"
				+ " |  _/ '_/ -_|_-<_-< / _` | | _ \\ || |  _|  _/ _ \\ ' \\ \r\n"
				+ " |_| |_| \\___/__/__/ \\__,_| |___/\\_,_|\\__|\\__\\___/_||_|\r\n"
				+ "                                                       "};
		for(String line: press) {
			System.out.println(BLUE+line);
		}
		System.out.println("Press Button Y to Scan QR Code\n"+
				"Press Button X to view record of journey and exit the program\n"+
				"Press Button B to Customise colours\n");
	}

	public void ScanningUI() {
		String[] code = {""
				+ "  ___                    _             _   _           ___  ___    ___         _     \r\n"
				+ " / __| __ __ _ _ _  _ _ (_)_ _  __ _  | |_| |_  ___   / _ \\| _ \\  / __|___  __| |___ \r\n"
				+ " \\__ \\/ _/ _` | ' \\| ' \\| | ' \\/ _` | |  _| ' \\/ -_) | (_) |   / | (__/ _ \\/ _` / -_)\r\n"
				+ " |___/\\__\\__,_|_||_|_||_|_|_||_\\__, |  \\__|_||_\\___|  \\__\\_\\_|_\\  \\___\\___/\\__,_\\___|\r\n"
				+ "                               |___/                                                 "};
		for (String line : code) {
			System.out.println(RESET+line+RESET);
		}
	}
	public void unsuccessfulUI() {
		String[] Unsuccessful = {""
				+"  _   _ _  _ ___ _   _  ___ ___ ___ ___ ___ ___ _   _ _    \r\n"
				+ " | | | | \\| / __| | | |/ __/ __| __/ __/ __| __| | | | |   \r\n"
				+ " | |_| | .` \\__ \\ |_| | (_| (__| _|\\__ \\__ \\ _|| |_| | |__ \r\n"
				+ "  \\___/|_|\\_|___/\\___/ \\___\\___|___|___/___/_|  \\___/|____|\r\n"
				+ "                                                           "
		};
		for(String line: Unsuccessful) {
			System.out.println(RED+line+RESET);
		}
		System.out.println(RED+"\nERROR: Unable to scan for code.\n"+RESET);
	}
	public void successUI() {
		String [] success = {""
				+ "  ___ _   _  ___ ___ ___ ___ ___    ___  ___    ___ ___  ___  ___   ___ ___  _   _ _  _ ___  \r\n"
				+ " / __| | | |/ __/ __| __/ __/ __|  / _ \\| _ \\  / __/ _ \\|   \\| __| | __/ _ \\| | | | \\| |   \\ \r\n"
				+ " \\__ \\ |_| | (_| (__| _|\\__ \\__ \\ | (_) |   / | (_| (_) | |) | _|  | _| (_) | |_| | .` | |) |\r\n"
				+ " |___/\\___/ \\___\\___|___|___/___/  \\__\\_\\_|_\\  \\___\\___/|___/|___| |_| \\___/ \\___/|_|\\_|___/ \r\n"
				+ "                                                                                             "};
		for(String line: success) {
			System.out.println(GREEN+line+RESET);
		}
		System.out.println("Inputs recieved\n");
	}

	public void validUI() {
		String[] success2 = {""
				+" __   ___   _    ___ ___   _ _____ ___ ___  _  _   ___ _   _  ___ ___ ___ ___ ___ ___ _   _ _    \r\n"
				+ " \\ \\ / /_\\ | |  |_ _|   \\ /_\\_   _|_ _/ _ \\| \\| | / __| | | |/ __/ __| __/ __/ __| __| | | | |   \r\n"
				+ "  \\ V / _ \\| |__ | || |) / _ \\| |  | | (_) | .` | \\__ \\ |_| | (_| (__| _|\\__ \\__ \\ _|| |_| | |__ \r\n"
				+ "   \\_/_/ \\_\\____|___|___/_/ \\_\\_| |___\\___/|_|\\_| |___/\\___/ \\___\\___|___|___/___/_|  \\___/|____|\r\n"
				+ "                                                                                                 "
		};
		for(String line: success2) {
			System.out.println(GREEN+line+RESET);
		}
	}

	public void invalidUI() {
		String[] invalid= {""
				+"  ___ _  ___   ___   _    ___ ___    ___ _  _ ___ _   _ _____ \r\n"
				+ " |_ _| \\| \\ \\ / /_\\ | |  |_ _|   \\  |_ _| \\| | _ \\ | | |_   _|\r\n"
				+ "  | || .` |\\ V / _ \\| |__ | || |) |  | || .` |  _/ |_| | | |  \r\n"
				+ " |___|_|\\_| \\_/_/ \\_\\____|___|___/  |___|_|\\_|_|  \\___/  |_|  \r\n"
				+ "                                                              "
		};
		for(String line: invalid) {
			System.out.println(RED+line+RESET);
		}
		System.out.println(RED+"ERROR: The values decoded are invalid\n"+RESET);
		System.out.println(CREAM+"The format of the code should be value1:value2\n"+RESET);
		System.out.println(CREAM+"Value1 should be between 15 and 85\n"+RESET);
		System.out.println(CREAM+"value2 should be smaller than or equal to 12 and should be an even number\n"+RESET);
	}

	public void colourUI() {
		System.out.println("Enter the corresponding number to select colours for the SwiftBot underlights colour customisation:\n"+RESET);
		System.out.println("1 - "+RED+"Red"+RESET+" and"+GREEN+" Green\n"+RESET);
		System.out.println("2 - "+PINK+"Pink"+RESET+" and"+YELLOW+" Yellow\n"+RESET);
		System.out.println("3 - "+PURPLE+"Purple"+RESET+" and"+MINT+" Mint\n"+RESET);
		System.out.println("4 - "+CYAN+"Sky Blue"+RESET+" and"+ORANGE+" Orange\n"+RESET);
		System.out.println("Press any other key to use default colors ("+GREEN+"Green"+RESET+" and "+BLUE+" Blue).\n"+RESET);
	}
	
	public void retraceUI() {
		System.out.println(CREAM+"SwiftBot is turning back to retrace its path.\r\n"+RESET);
		System.out.println("RETRACING PATH\n");
		System.out.println(CREAM+"Traversing the path with same number of ZigZag turns\n"+RESET);
	}
	
	public void journeyComplete() {
		System.out.println(GREEN+"ZIGZAG JOURNEY COMPLETED\n");
		System.out.println(GREEN+"The SwiftBot has reached its original position\n"+RESET);
		System.out.println("Turning the LEDs off\n"+RESET);
	}
	
	public void exit() {
		String []thankYou = {
				"\n  _____ _              _                   \r\n"
						+ " |_   _| |_  __ _ _ _ | |__  _  _ ___ _  _ \r\n"
						+ "   | | | ' \\/ _` | ' \\| / / | || / _ \\ || |\r\n"
						+ "   |_| |_||_\\__,_|_||_|_\\_\\  \\_, \\___/\\_,_|\r\n"
						+ "                             |__/          "
		};
		for (String line : thankYou) {
			System.out.println(BLUE+line+RESET);
		}
		System.out.println("Exiting the program.\n");
	}
}