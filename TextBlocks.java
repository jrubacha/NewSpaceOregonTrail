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
        ui.println("\nOption 1: Saturn V Rocket\nA flight vehicle straight out of history, this rocket will get you where you need to go. So long as that place is the Moon and your initial flight crew small, three passengers maximum including you Captain.\nCost: 1000\nCapacity: 3\nRange: Moon Base");
    }
    public void printFalconText(){
        ui.println("\nOption 2: Atlas Falcon\nA slightly more modern alternative to the Saturn V, the Atlas Falcon is similarly capable of lifting you and three others into orbit.\nCost: 5000\nCapacity: 4\nRange: Moon Base");
    }
    public void printNewShepardText(){
        ui.println("\nOption 3: New Shepard XC\nIt’s not the prettiest spacecraft, but the New Shepard will get you out into the solar system. With an extended range from its earlier counterparts, this ship will take you all the way to Mars, maybe further if you’re careful with your supplies.\nCost: 10000\nCapacity: 6\nRange: Inner Ring Station");
    }
    public void printArtemisText(){
        ui.println("\nOption 4: Artemis N\nOne of the world’s leaders in solar system travel, Artemis doesn’t disappoint with their ‘N’ series craft. Designed for long journeys in mind, the Artemis N will take you wherever you need to go.\nCost: 20000\nCapacity: 10\nRange: Kuiper Belt");
    }
    public void printNewOrionText(){
        ui.println("\nOption 5: New Orion\nThe interstellar flight vehicle. Top of the line in speed, luxury, and navigational control, you can’t go wrong with this craft. Travel in style to your destination and never worry about a thing.\nCost: 40000\nCapacity: 12\nRange: Proxima b");
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
            ui.print("\n1. See next ship\n2. Purchase this ship\n\nWhat would you like to do? ");
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
    public void printLaunchPrompt(){
        ui.print("\n1. Launch Today\n2. Postpone launch one day\n\nWhat would you like to do? ");
    }

    public void printLaunchSuccess(SpaceCraft myCraft) {
        ui.print("Congrats on making it to space. You're on your way to the Moon now. ");
    }

    public void printDailyHeader(int day, Crew crew, Supplies.Food food, currentLocation myLocation) {
        ui.println("Hello. It's day #" + day + " in space.");
        ui.println("Crew Condition: " + crew.getOverallCrewHealth());
        ui.println("Food: " + food.getQuantity() + " lbs remaining");
        ui.println("Location: " + myLocation);
        ui.println("\n=========================");
    }

    public void printDailyMessage(int day, Crew crew, Supplies.Food food, currentLocation myLocation) {
        ui.clear();
        printDailyHeader(day, crew, food, myLocation);
        ui.println("1. Continue on your journey");
        ui.println("2. Check supplies");
        ui.println("3. Change food rations");
        ui.println("4. Attempt to trade");
        ui.println("5. Talk to people");
        ui.println("6. Perform ship maintenance");
        ui.print("\nWhat is your choice? ");
    }

    public void printSupplycheck(Supplies.Food food, SpaceCraft craft) {
        ui.clear();   
        ui.println("You currently have the following supplies:\n"); 
        ui.println(food.getQuantity() + " lbs of food");
        ui.println(craft.getCurrentFuel() + " fuel");
        ui.pressEnter();
    }

    public void printMoonWelcome() {
        ui.clear();
        ui.println("Wecolme to Moon Base 1! Established in 2154, Moon Base 1 is a thriving hub of near-field research, commerce, and entertainment. You are welcome to stay in your docking station as long as you want, parking here is always free. Check out the vendors if you need a new ship or more supplies. Star Command Regional offices are always open if want to hire/fire any crew members. Interstellar launch rings will be waiting to take you on to Mars when you're ready to leave.\n");
        ui.pressEnter();
    }

    public void printMoonDailyMessage(int day, Crew crew, Supplies.Food food, SpaceCraft craft, currentLocation myLocation){
        ui.clear();
        printDailyHeader(day, crew, food, myLocation);
        ui.println("1. Continue on your journey");
        ui.println("2. Manage supplies");
        ui.println("3. Manage crew");
        ui.println("4. Manage craft");
        ui.println("5. Talk to people");
        ui.println("6. Stay overnight on Moon Base");
        ui.print("\nWhat is your choice? ");
    }

    public void printManageSuppliesDialogue(){
        ui.clear();
        ui.println("< Managing Supplies >\n");
        ui.println("1. Check supplies");
        ui.println("2. Buy supplies");
        ui.println("3. Sell supplies");
        ui.println("4. Change food ration size");
        ui.println("5. Attempt to trade");
        ui.println("6. Do nothing");
        ui.print("\nWhat is your choice? ");
    }
    public void handleManageSupplies(int selection, Supplies.Food food, Supplies.Money money) {
        switch (selection) {
            case 1:
                food.printFoodQuantityAndRationSize();
                break;
            case 2:
                food.buyFood();
                break;
            case 3:   
                food.sellFood();
                break;
            case 4:
                food.printChangeRationSizePrompt();
                int userSelc = keyboard.nextInt();
                food.changeRationSize(userSelc);
                break;
            case 5:
                ui.println("Trade place holder.");
                break;
            case 6:
                break;
            default:
                break;
        }
    }

    public void printManageCrewDialogue(){
        ui.clear();
        ui.println("< Managing Crew >\n");
        ui.println("1. Check crew list");
        ui.println("2. Hire crew members");
        ui.println("3. Fire crew members");
        ui.println("4. Do nothing");
        ui.print("\nWhat is your choice? ");
    }
    public void printManageCraftOptions(){
        ui.clear();
        ui.println("< Managing Space Craft >\n");
        ui.println("1. Check Space Craft");
        ui.println("2. Sell Space Craft");
        ui.println("3. Buy Space Craft");
        ui.println("4. Craft Maintenance");
        ui.println("5. Do nothing");
        ui.print("\nWhat is your choice?");
    }
    public void printCraftMaintenanceOptions(){
        ui.clear();
        ui.println("< Space Craft Maintenance >\n");
        ui.println("1. Have crew engineers perform maintenance - minimal repair gain, but free");
        ui.println("2. Have Moon Base Repairman perform maintenance - excellent repair gain, $1000");
        ui.println("3. Do nothing");
        ui.print("\nWhat is your choice? ");
    }
}
