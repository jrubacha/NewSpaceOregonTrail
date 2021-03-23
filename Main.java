import java.util.*;
class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        TextBlocks text = new TextBlocks();
        Scanner keyboard = new Scanner(System.in);
        Crew myCrew = new Crew();
        //Supplies.Money myMoney = new Supplies.Money();
        Supplies.Food myFood = new Supplies.Food(0);
        currentLocation myLocation = currentLocation.EARTH;
        SpaceCraft myCraft = new SpaceCraft();
        int myMoney = 65000;

        // Welcome and get Captain Name
        text.printGameIntro();
        myCrew.addCaptain();


        // Ship Selection - Earth
        text.shipSelectionPrompt(myCrew.getCaptainName(), myMoney);
        myCraft = text.getCraftSelection(text.loopShipText());
        myMoney = myMoney - myCraft.getCost();
        ui.println(myCraft.getCraftName());
        

        // Hire a crew
        myCrew.assembleCrew(myCraft.capacity);
        myCrew.printCrewList();

        // Buy food for said crew
        ui.println("Now that you have a crew, you'll need to take care of them.\n\nYou'll need to make initial purchases of food and water to last at least until you can get to the moon.");
        ui.pressEnter();
        myMoney = myFood.buyFood(myMoney);

        // Test the weather stuff
        Weather myWeather = new Weather();
        int counter = 1;
        int userSelc = 0;
        while (counter<15 && userSelc !=1) {
            myWeather.rollWeatherConditions();
            ui.clear();
            ui.println("Launch Window - Day " + counter++ + " of 14.");
            myWeather.printCurrentWeatherForecast();
            text.printLaunchPrompt();
            userSelc = keyboard.nextInt();
        }
        if (counter>15){
            ui.println("Oh no! You waited too long.");
            System.exit(0); // you lost
        } else if (!myWeather.isLaunchSuccessful()) {
            ui.clear();
            ui.println("*************************************************\n");
            ui.println("Weather conditions proved unfavorable for the launch.\n\nStar Command is sorry to report that all hands were lost.");
            ui.println("\n*************************************************");
            System.exit(0); // you lost
        } else {
            ui.clear();
            ui.println("Congrats! You didn't die on launch.");
            myLocation = currentLocation.SPACE;
        }

        int tripOneDuration = myCraft.calculateTimeToMoon();
        int tripOneCurrentDay = 1;
        while (ui.areWeAlive(myFood, myCraft, myCrew, tripOneCurrentDay) && tripOneCurrentDay < tripOneDuration) {
            myFood.eatFood(myCrew.sumTotalOfCrew());
            myCraft.calculateFuelBurn();
            userSelc = 0;
            while(userSelc != 1) {
                text.printDailyMessage(tripOneCurrentDay, myCrew, myFood, myLocation);
                userSelc = keyboard.nextInt();
                switch (userSelc) {
                    case 2:
                        text.printSupplycheck(myFood, myCraft);
                        break;
                    case 3:
                        myFood.printChangeRationSizePrompt();
                        myFood.changeRationSize(keyboard.nextInt());
                        break;
                    case 4:
                        if (myCrew.doesCrewHaveCommOfficer()) {
                            ui.println("Trade dialogue.");
                        } else {
                            ui.println("You don't have a Communications Officer. You cannot contact anyone to trade with.");
                        }
                        ui.pressEnter();
                        break;
                    case 5:
                        if (myCrew.doesCrewHaveCommOfficer()) {
                            ui.println("Talk dialogue.");
                        } else {
                            ui.println("You don't have a Communications Officer. You cannot contact anyone to talk with.");
                        }
                        ui.pressEnter();
                        break;
                    case 6:
                        if (myCrew.doesCrewHaveEngineer()) {
                            ui.println("Repair dialogue.");
                        } else {
                            ui.println("You don't have an Engineer. You cannot perform ship maintenance.");
                        }
                        ui.pressEnter();
                        break;
                    default:
                        break;
                }
            }
            tripOneCurrentDay++;
        } // trip one

        // Welcome to the MOON!
        text.printMoonWelcome();
        myLocation = currentLocation.MOON_BASE_1;

        userSelc = 0;
        int userSelc2 = 0;
        while (userSelc != 1) {
            text.printMoonDailyMessage(tripOneCurrentDay, myCrew, myFood, myCraft, myLocation);
            userSelc = keyboard.nextInt();
            switch (userSelc) {
                case 1:
                    ui.println("Continue on journey placeholder");
                    break;
                case 2:
                    text.printManageSuppliesDialogue();
                    userSelc2 = keyboard.nextInt();
                    text.handleManageSupplies(userSelc2, myFood, myMoney);
                    break;
                case 3:
                    text.printManageCrewDialogue();
                    userSelc2 = keyboard.nextInt();
                    break;
                case 4:
                    text.printManageCraftOptions();
                    userSelc2 = keyboard.nextInt();
                    break;
                case 5:
                    ui.println("Take to people place holder");
                    break;
                case 6:
                    ui.println("stay overnight placeholder"); // this probably not needed
                    tripOneCurrentDay++;
                    break;
                default:
                    break;
            }
        }
    } 
}
