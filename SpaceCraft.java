public class SpaceCraft {
    UserInterface ui = new UserInterface();
    TextBlocks text = new TextBlocks();
    enum craftQuality {
        POOR,
        FAIR,
        GOOD
    }
    enum craftSpeed {
        SLOW,
        AVERAGE,
        FAST
    }
    enum craftTankSize {
        SMALL,
        MEDIUM,
        LARGE
    }
    enum craftRange {
        MOON,
        MARS,
        INNER_BELT,
        OUTER_BELT,
        EVERYWHERE
    }
    String name;
    craftRange range;
    craftQuality quality;
    craftSpeed speed;
    static craftTankSize tankSize;
    int cost, capacity;
    static int currentFuel = getMaxFuel();

    public void displayCraftSpecs() {
        ui.println(name);
        ui.println("Quality: " + quality);
        ui.println("Speed: " + speed);
        ui.println("Capacity: " + capacity);
        ui.println("Fuel: " + tankSize);
        ui.println("Cost: " + cost);
    }

    public String getCraftName() {
        return name;
    }
    public void setCraftName(String newCraftName){
        name = newCraftName;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int maxCrewSize) {
        capacity = maxCrewSize;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int newCost){
        cost = newCost;
    }
    public int getCurrentFuel() {
        return currentFuel;
    }
    public static int getMaxFuel() {
        if (tankSize == craftTankSize.LARGE) {
            return 1000;
        } else if (tankSize == craftTankSize.MEDIUM) {
            return 750;
        } else {
            return 500;
        }
    }
    
    public void calculateFuelBurn() {
        int fuelBurn = 10;
        currentFuel = currentFuel - fuelBurn;
    }
    public boolean isFuelRemaining() {
        if (currentFuel > 0) {
            return true;
        } else {
            return false;
        }
    }
    public void resetFuelTo(int fuelAmount){
        currentFuel = fuelAmount;
    }

    public void setTankSizeToSmall() {
        tankSize = craftTankSize.SMALL;
    }
    public void setTankSizeToMedium() {
        tankSize = craftTankSize.MEDIUM;
    }
    public void setTankSizeToLarge() {
        tankSize = craftTankSize.LARGE;
    }

    public void setQualitytoHigh(){
        quality = craftQuality.GOOD;
    }
    public void setQualitytoFair(){
        quality = craftQuality.FAIR;
    }
    public void setQualitytoPoor(){
        quality = craftQuality.POOR;
    }
    public String getQualityString(){
        return quality.toString();
    }
    public void setSpeedtoSlow(){
        speed = craftSpeed.SLOW;
    }
    public void setSpeedtoMedium(){
        speed = craftSpeed.AVERAGE;
    }
    public void setSpeedtoFast(){
        speed = craftSpeed.FAST;
    }
    public String getSpeedString(){
        return speed.toString();
    }
    public void setRangetoMoon(){
        range = craftRange.MOON;
    }
    public void setRangetoMars(){
        range = craftRange.MARS;
    }
    public void setRangetoInnerBelt(){
        range = craftRange.INNER_BELT;
    }
    public void setRangetoOuterBelt(){
        range = craftRange.OUTER_BELT;
    }
    public void setRangetoEverywhere(){
        range = craftRange.EVERYWHERE;
    }
    public String getRangeString(){
        return range.toString();
    }

    public int calculateTimeToMoon() {
        if (speed == craftSpeed.FAST) {
            return 2;
        } else if (speed == craftSpeed.AVERAGE) {
            return 3;
        } else {
            return 4;
        }
    }

    public int calculateTimeToMars() {
        if (speed == craftSpeed.FAST) {
            return (30 * 6);
        } else if (speed == craftSpeed.AVERAGE) {
            return (30 * 7);
        } else {
            return (30 * 8);
        }
    }

    public int calculateTimeToInnerBeltStation() {
        if (speed == craftSpeed.FAST) {
            return (30 * 6 * 3); // essentially, it's 3 times the length of time to mars
        } else if (speed == craftSpeed.AVERAGE) {
            return (30 * 7 * 3);
        } else {
            return (30 * 8 * 3);
        }
    }

    public int buyCraftFromStation(int whichCraft){
        text.printSpaceCraftVendorDialogue();
        boolean needAShip = true;

        // "Sell" your current ship
        int value = (int) (cost * 0.5);
        while (needAShip) {
            switch (whichCraft) {
                case 1:
                    // skybird
                    needAShip = false;
                    break;
                case 2:
                    // helios 9
                    needAShip = false;
                    break;
                case 3: 
                    // pegasus
                    needAShip = false;
                    break;
                case 4:
                    // nevermind, no sale
                    needAShip = false;
                    break;
                default:
                    ui.println("That's not a valid choice. Please try again");
                    break;
            }
        }
        return (cost-value);
    }
}
