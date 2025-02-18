import java.awt.image.BufferedImage;

public class ScanQRCode {
	static UserInterface UI = new UserInterface();
	static ZigzagMovement movement = new ZigzagMovement();
	
	public void scanQRCode() {
	    long startTime = System.currentTimeMillis();
	    long endTime = startTime + 20000; // 20 seconds in milliseconds
	    int[] purple = {143, 67, 230};
	    int[] red = {255, 0, 0};
	    int[] yellow = {255, 250, 0};

	    System.out.println("Starting 20s timer");
	    UI.ScanningUI();

	    try {
	        while (System.currentTimeMillis() < endTime) {
	            Zigzag.swiftBot.fillUnderlights(yellow);

	            BufferedImage img = Zigzag.swiftBot.getQRImage();
	            String decodedMessage = Zigzag.swiftBot.decodeQRImage(img);
	            
	            long elapsedTime = (System.currentTimeMillis() - startTime)/1000;
	            if(elapsedTime%5 == 0) {
	            	System.out.println("Time elapsed: "+elapsedTime+" seconds");
	            }

	            if (!decodedMessage.isEmpty()) {
	                if (isMessageValid(decodedMessage)) {
	                	Zigzag.ZigZagLength = ZL(decodedMessage);
	                	Zigzag.ZigZagSections = ZS(decodedMessage);
	        			System.out.println("Decoded message -> Zigzag Length => " + Zigzag.ZigZagLength + " Zigzag Sections => " + Zigzag.ZigZagSections);

	                    UI.successUI();
	                    Zigzag.swiftBot.fillUnderlights(purple);
	                    Thread.sleep(1000);

	                    System.out.println("Validating code");
	                    Thread.sleep(250);
	                    UI.validUI();

	                    System.out.println("QR Code scanning completed.");
	                    System.out.println("Place SwiftBot to start the ZigZag movement");
	                    Thread.sleep(3000);
	                    
	                    movement.ZigZag(Zigzag.ZigZagLength, Zigzag.ZigZagSections, false);
	                    UI.retraceUI();
	                    movement.ZigZag(Zigzag.ZigZagLength, Zigzag.ZigZagSections, true);
	                    UI.journeyComplete();
	                    Zigzag.ZigZagJourneys++;
	                    break;
	                } else {
	                    UI.invalidUI();
	                    Zigzag.swiftBot.fillUnderlights(yellow);
	                }
	            } else {
	                UI.unsuccessfulUI();
	                Zigzag.swiftBot.fillUnderlights(red);
	            }
	        }
	    } catch (Exception e) {
	        System.out.println(UI.RED + "ERROR: Unable to scan for QR code" + e.getMessage() + UI.RESET);
	        e.printStackTrace();
	        System.exit(5);
	    }

	    Zigzag.swiftBot.disableUnderlights();
	    System.out.println("Loop finished!");
	}
	
	public int ZL(String message) {
		int ZigzagLength=Integer.parseInt(message.substring(0, message.indexOf(":")));
		return ZigzagLength;
	}
	
	public int ZS(String message) {
		int ZigzagSections = Integer.parseInt(message.substring(message.indexOf(":")+1));
		return ZigzagSections;
	}
	private boolean isMessageValid (String message) {
		try {
			Zigzag.ZigZagLength = ZL(message);
			Zigzag.ZigZagSections = ZS(message);
			if((Zigzag.ZigZagLength>=15 && Zigzag.ZigZagLength <=85) && (Zigzag.ZigZagSections<=12 && Zigzag.ZigZagSections%2==0)) {
				System.out.println("The decoded message is valid");
				return true;
			}
		}catch (Exception e) {
			System.out.println("ERROR: The values entered are invalid");
		}
		return false;
	}
}