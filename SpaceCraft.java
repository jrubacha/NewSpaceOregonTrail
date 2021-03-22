public class SpaceCraft {
    UserInterface ui = new UserInterface();
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
    String name;
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
}