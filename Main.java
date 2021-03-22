import java.util.*;
class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        TextBlocks text = new TextBlocks();
        Scanner keyboard = new Scanner(System.in);
        Crew myCrew = new Crew();
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
        ui.println("Test. amt of food " + myFood.getQuantity() + " and have we starved? " + myFood.hasCrewStarved());

        // Test the weather stuff
        Weather myWeather = new Weather();
        int counter = 1;
        while (true) {
            myWeather.rollWeatherConditions();
            ui.clear();
            ui.println("Launch Window - Day " + counter++ + " of 14.");
            myWeather.printCurrentWeatherForecast();
            ui.pressEnter();
        }
    } 
}
