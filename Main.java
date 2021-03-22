import java.util.*;
class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        TextBlocks text = new TextBlocks();
        Scanner keyboard = new Scanner(System.in);
        Crew myCrew = new Crew();
        myCrew.addCaptain();
        ui.println("Ship pick");
        SpaceCraft myCraft = new SpaceCraft();
        myCraft = text.getCraftSelection(text.loopShipText());
        ui.println(myCraft.getCraftName());

        // Hire a crew
        myCrew.assembleCrew(myCraft.capacity);
        myCrew.printCrewList();

        // Buy food for said crew
        ui.println("buy food. how much want");
        Supplies.Food myFood = new Supplies.Food(keyboard.nextInt());

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
            System.exit(0);
        } else if (!myWeather.isLaunchSuccessful()) {
            ui.println("Oh no! You died.");
            System.exit(0);
        } else {
            ui.println("Congrats! You didn't die on launch.");
        }

        int tripOneDuration = myCraft.calculateTimeToMoon();
        int tripOneCurrentDay = 1;
        while (ui.areWeAlive(myFood, myCraft, myCrew, tripOneCurrentDay) && tripOneCurrentDay < tripOneDuration) {
            myFood.eatFood(myCrew.sumTotalOfCrew());
            text.printDailyMessage(tripOneCurrentDay++, myCrew);
        }
    } 
}
