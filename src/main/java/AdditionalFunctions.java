import java.util.Scanner;

public class AdditionalFunctions {
	private final static int[] gradient1 = {150, 182, 197}, gradient2 = {159, 150, 197}, gradient3 = {170, 143, 191}, gradient4 = {197, 150, 195};
	static Scanner sc = new Scanner(System.in);
	public void Ultrasound(int distance) {
		try {
			double obstacle = Zigzag.swiftBot.useUltrasound();

			if (obstacle < distance) {
				Zigzag.swiftBot.stopMove();  // Stop the bot's movement
				System.out.println(Zigzag.UI.RED+"Obstacle detected! Stopping bot.");
				System.out.println(Zigzag.UI.red+"Distance from front-facing obstacle: " + obstacle + " cm"+RESET);
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
	public void underlight() {
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
			System.out.println(red+"ERROR: Unable to light up swiftbot underlights\n"+RESET);
		}
	}
}