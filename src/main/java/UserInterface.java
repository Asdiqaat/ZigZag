public class UserInterface {
	private static final String CREAM = "\u001B[38;5;11m",cyan = "\u001B[38;5;153m",yellow="\u001B[38;5;227m",PURPLE ="\u001B[38;5;177m";
	private static final String RESET = "\u001B[0m",red="\u001B[38;5;160m";
	private static final String combinedColour2 = "\u001B[38;5;17m\u001B[48;5;15m";
	private static final String green = "\u001B[38;5;2m", colour="\u001B[38;5;174m";
	private static final String colour7 = "\u001B[38;5;33m", pink ="\u001B[38;5;169m";
	private static final String mint="\u001B[38;5;157m",orange="\u001B[38;5;209m";

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
			System.out.println(combinedColour2+line+RESET);
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
			System.out.println(colour7+line);
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
			System.out.println(red+line+RESET);
		}
		System.out.println(red+"\nERROR: Unable to scan for code.\n"+RESET);
	}
	public void successUI() {
		String [] success = {""
				+ "  ___ _   _  ___ ___ ___ ___ ___    ___  ___    ___ ___  ___  ___   ___ ___  _   _ _  _ ___  \r\n"
				+ " / __| | | |/ __/ __| __/ __/ __|  / _ \\| _ \\  / __/ _ \\|   \\| __| | __/ _ \\| | | | \\| |   \\ \r\n"
				+ " \\__ \\ |_| | (_| (__| _|\\__ \\__ \\ | (_) |   / | (_| (_) | |) | _|  | _| (_) | |_| | .` | |) |\r\n"
				+ " |___/\\___/ \\___\\___|___|___/___/  \\__\\_\\_|_\\  \\___\\___/|___/|___| |_| \\___/ \\___/|_|\\_|___/ \r\n"
				+ "                                                                                             "};
		for(String line: success) {
			System.out.println(green+line+RESET);
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
			System.out.println(green+line+RESET);
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
			System.out.println(red+line+RESET);
		}
		System.out.println(red+"ERROR: The values decoded are invalid\n"+RESET);
		System.out.println(CREAM+"The format of the code should be value1:value2\n"+RESET);
		System.out.println(CREAM+"Value1 should be between 15 and 85\n"+RESET);
		System.out.println(CREAM+"value2 should be smaller than or equal to 12 and should be an even number\n"+RESET);
	}

	public void colourUI() {
		System.out.println("Enter the corresponding number to select colours for the SwiftBot underlights colour customisation:\n"+RESET);
		System.out.println("1 - "+red+"Red"+RESET+" and"+green+" Green\n"+RESET);
		System.out.println("2 - "+pink+"Pink"+RESET+" and"+yellow+" Yellow\n"+RESET);
		System.out.println("3 - "+PURPLE+"Purple"+RESET+" and"+mint+" Mint\n"+RESET);
		System.out.println("4 - "+cyan+"Sky Blue"+RESET+" and"+orange+" Orange\n"+RESET);
		System.out.println("Press any other key to use default colors ("+green+"Green"+RESET+" and "+colour7+" Blue).\n"+RESET);
	}
}
