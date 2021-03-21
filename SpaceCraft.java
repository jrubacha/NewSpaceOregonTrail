public class SpaceCraft {
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

    public SpaceCraft(String name, craftSpeed speed, craftQuality quality, int capacity, int cost, craftTankSize tankSize) {
        this.name = name;
        this.speed = speed;
        this.quality = quality;
        this.capacity = capacity;
        this.cost = cost;
        SpaceCraft.tankSize = tankSize;
    }

    public String getCraftName() {
        return name;
    }
    public int getCapacity() {
        return capacity;
    }
    public int getCost() {
        return cost;
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


}
