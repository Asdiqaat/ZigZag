import java.util.Scanner;

public class AdditionalFunctions {
	private static final String RESET = "\u001B[0m",red="\u001B[38;5;160m",PURPLE ="\u001B[38;5;177m",yellow="\u001B[38;5;227m",peach="\u001B[38;5;219m",grey="\u001B[38;5;247m";
	private static final String mint="\u001B[38;5;157m",orange="\u001B[38;5;209m", pink ="\u001B[38;5;169m",cyan = "\u001B[38;5;153m";
	private int[] Colour1 = {0, 255, 0}; // Default green
	private int[] Colour2 = {0, 0, 255}; // Default blue
	private final static int[] gradient1 = {150, 182, 197}, gradient2 = {159, 150, 197}, gradient3 = {170, 143, 191}, gradient4 = {197, 150, 195};
	UserInterface UI = new UserInterface();
	static Scanner sc = new Scanner(System.in);
	public void Ultrasound(int distance) {
		try {
			double obstacle = Zigzag.swiftBot.useUltrasound();

			if (obstacle < distance) {
				Zigzag.swiftBot.stopMove();  // Stop the bot's movement
				System.out.println(red+"Obstacle detected! Stopping bot.");
				System.out.println(red+"Distance from front-facing obstacle: " + obstacle + " cm"+RESET);
				System.out.println("Waiting 3 seconds");

				Thread.sleep(3000);

				obstacle = Zigzag.swiftBot.useUltrasound();

				System.out.println(red+"Obstacle still detected. Repeating check."+RESET);
				Ultrasound(distance);  // Recursively call the method to keep checking
			}
			else {
				System.out.println("No obstacle!!"); //change this in req
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(red+"ERROR: Ultrasound Unsuccessful"+RESET);
			System.exit(5);
		}
	}
	public static void underlight() {
		try {
			Zigzag.swiftBot.fillUnderlights(gradient1);
			Thread.sleep(1000);
			Zigzag.swiftBot.fillUnderlights(gradient2);
			Thread.sleep(1000);
			Zigzag.swiftBot.fillUnderlights(gradient3);
			Thread.sleep(1000);
			Zigzag.swiftBot.fillUnderlights(gradient4);
			Thread.sleep(1000);
			Zigzag.swiftBot.disableUnderlights();
		}catch (Exception e) {
			System.out.println("Prob with underlight");
		}
	}
	public void configureColors() {
        UI.colourUI();
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                Colour1 = new int[]{255,0,0}; // red
                Colour2 = new int[]{255, 229, 180}; // change to green
                break;
            case "2":
                Colour1 = new int[]{255, 105, 180}; // Pink
                Colour2 = new int[]{242, 250, 92}; // yellow
                break;
            case "3":
                Colour1 = new int[]{119, 8, 166}; // change to purple
                Colour2 = new int[]{152, 255, 152}; // Mint
                break;
            case "4":
                Colour1 = new int[]{153, 195, 240}; // sky blue
                Colour2 = new int[]{255, 165, 0}; // orange
                break;
            default:
                System.out.println("Using default colors (Green and Blue).");
        }
    }
}
