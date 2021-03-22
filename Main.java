import java.util.*;
class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        TextBlocks text = new TextBlocks();
        Scanner keyboard = new Scanner(System.in);
        ui.println("Ship pick");
        SpaceCraft myCraft = new SpaceCraft();
        myCraft = text.getCraftSelection(text.loopShipText());
        ui.println(myCraft.getCraftName());

        ui.println("buy food. how much want");
        Supplies.Food myFood = new Supplies.Food(keyboard.nextInt());
        ui.println("Test. amt of food " + myFood.getQuantity() + " and have we starved? " + myFood.hasCrewStarved());

    } 
}
