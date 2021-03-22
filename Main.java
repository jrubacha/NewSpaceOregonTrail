class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        TextBlocks text = new TextBlocks();
        ui.println("Ship pick");
        SpaceCraft myCraft = new SpaceCraft();
        myCraft = text.getCraftSelection(text.loopShipText());
        ui.println(myCraft.getCraftName());
    } 
}

// String name, craftSpeed speed, craftQuality quality, int capacity, int cost, craftTankSize tankSize
