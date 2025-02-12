import swiftbot.SwiftBotAPI;
public class SpeedTest {
	static SwiftBotAPI swiftBot;
	public static void main(String[] args) {
		swiftBot = new SwiftBotAPI();
		//swiftBot.move(75, 100, 5000);//speed 100
		swiftBot.move(72, 90, 5000);//speed 90
		//swiftBot.move(70, 80, 5000);//speed 80
		//swiftBot.move(58, 70, 5000);//speed 70
		//swiftBot.move(50, 60, 5000);//speed 60
		//swiftBot.move(40, 50, 5000);//speed 50
		//swiftBot.move(32, 40, 5000);
	}
}
