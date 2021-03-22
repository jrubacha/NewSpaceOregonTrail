import java.util.Scanner;

public class TextBlocks {
    UserInterface ui = new UserInterface();
    Scanner keyboard = new Scanner(System.in);

    public SpaceCraft getCraftSelection(int whichCraft){
        SpaceCraft firstCraft = new SpaceCraft();
        boolean needAShip = true;
        while (needAShip) {
            switch (whichCraft) {
                case 1:
                    firstCraft.setCraftName("Saturn V");
                    firstCraft.setCapacity(3);
                    firstCraft.setQualitytoPoor();
                    firstCraft.setSpeedtoSlow();
                    firstCraft.setTankSizeToSmall();
                    firstCraft.setCost(1000);
                    needAShip = false;
                    break;
                case 2:
                    firstCraft.setCraftName("Falcon Heavy");
                    firstCraft.setCapacity(4);
                    firstCraft.setQualitytoPoor();
                    firstCraft.setSpeedtoSlow();
                    firstCraft.setTankSizeToMedium();
                    firstCraft.setCost(5000);
                    needAShip = false;
                    break;
                case 3: 
                    firstCraft.setCraftName("New Shepard XC");
                    firstCraft.setCapacity(6);
                    firstCraft.setQualitytoFair();
                    firstCraft.setSpeedtoMedium();
                    firstCraft.setTankSizeToMedium();
                    firstCraft.setCost(10000);
                    needAShip = false;
                    break;
                case 4:
                    firstCraft.setCraftName("Artemis N");
                    firstCraft.setCapacity(10);
                    firstCraft.setQualitytoHigh();
                    firstCraft.setSpeedtoFast();
                    firstCraft.setTankSizeToMedium();
                    firstCraft.setCost(20000);
                    needAShip = false;
                    break;
                case 5:
                    firstCraft.setCraftName("New Orion");
                    firstCraft.setCapacity(12);
                    firstCraft.setQualitytoHigh();
                    firstCraft.setSpeedtoFast();
                    firstCraft.setTankSizeToLarge();
                    firstCraft.setCost(40000);
                    needAShip = false;
                    break;
                default:
                    ui.println("That's not a valid choice. Please try again");
                    break;
            }
        }
        return firstCraft;
    }

    public void printSaturnVText(){
        ui.println("\nSaturn V Text");
    }
    public void printFalconText(){
        ui.println("\nFalcon Text");
    }
    public void printNewShepardText(){
        ui.println("\nNew Shepard Text");
    }
    public void printArtemisText(){
        ui.println("\nArtemis Text");
    }
    public void printNewOrionText(){
        ui.println("\nNew Orion Text");
    }

    public int loopShipText() {
        boolean stillBrowsing = true;
        int counter = 1;
        while (stillBrowsing) {
            ui.clear();
            switch (counter) {
                case 1:
                    printSaturnVText();
                    break;
                case 2:
                    printFalconText();
                    break;
                case 3:
                    printNewShepardText();
                    break;
                case 4:
                    printArtemisText();
                    break;
                case 5:
                    printNewOrionText();
                    break;
                default:
                    ui.println("Something's wrong.");
                    break;
            }
            // Give user options
            ui.println("\n1. See next ship\n2. Purchase this ship\n\nWhat would you like to do? ");
            // Are we done?
            if (keyboard.nextInt() == 2) {
                stillBrowsing = false; 
            } else {
                counter++;
                // Loop back to beginning of ship list
                if (counter > 5) {
                    counter = 1;
                }
            }
        }
        return (counter);
    }
}
