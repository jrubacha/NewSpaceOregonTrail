import java.util.*;
class Supplies {
    UserInterface ui = new UserInterface();
    Scanner keyboard = new Scanner(System.in);
    static int amount;

    public int getQuantity(){
        return amount;
    }
    public void setQuantity(int newAmount){
        amount = newAmount;
    }
    public void addQuantity(int newAmount) {
        amount = amount + newAmount;
    }
    public void reduceQuantity(int newAmount) {
        amount = amount - newAmount;
    }

    public static class Food extends Supplies {
        FoodRationSize rationSize;
        int foodCost = 2;
        int foodSale = 1;
        enum FoodRationSize {
            BAREBONES,
            MEAGER,
            FILLING
        }
        
        public Food (int quantityOfFood) {
            Supplies.amount = quantityOfFood;
            rationSize = FoodRationSize.FILLING;
        }
        public void printFoodQuantityAndRationSize(){
            ui.println("You have " + amount + " lbs of food.\nYour ration size is set to " + rationSize);
        }
        public void sellFood() {
            ui.println("< Selling Food >\n\nHow many pounds of food would you like to sell? ");
            int sellAmount = keyboard.nextInt();
            //sellQuantity(sellAmount, foodBaseValue);
            ui.println("You now have " + amount + " lbs of food.\n\nYou have $");
            ui.pressEnter();
        }
        public int buyFood(int money) {
            ui.print("< Buying Food >\n\nThe average person eats 2 lbs of food a day.\n\nHow many pounds of food would you like to buy? ");
            int buyAmount = keyboard.nextInt();
            amount = amount + buyAmount;
            money = money - buyAmount * foodCost;
            ui.println("You now have " + amount + " lbs of food and $" + money);
            ui.pressEnter();
            return money;
        }

        public void setRationSizeToBareBones(){
            rationSize = FoodRationSize.BAREBONES;
        }
        public void setRationSizetoMeager(){
            rationSize = FoodRationSize.MEAGER;
        }
        public void setRationSizetoFilling(){
            rationSize = FoodRationSize.FILLING;
        }
        public void eatFood(int crewSize) {
            int rateOfConsumption;
            switch (rationSize) {
                case BAREBONES:
                    rateOfConsumption = 1;
                    break;
                case MEAGER:
                    rateOfConsumption = 2;
                    break;
                default:
                    rateOfConsumption = 3;
            }
            amount = amount - (crewSize * rateOfConsumption);
        }
        public void changeRationSize(int userChoice){
            if (userChoice == 3) {
                setRationSizeToBareBones();
            } else if (userChoice == 2) {
                setRationSizetoMeager();
            } else {
                setRationSizetoFilling();
            }
        }
        public boolean hasCrewStarved() {
            if (amount <= 0) {
                return true;
            } else {
                return false;
            }
        }
        public void printChangeRationSizePrompt(){
            ui.clear();
            ui.println("Change food rations\n< Currently " + rationSize +" >");
            ui.print("The amount of food the people in your crew each each day can change. These amounts are:\n1. Filling - meals are large and generous.\n2. Meager - meals are small, but adequate.\n3. Bare bones - meals are very small; everyone stays hungry.\n\nWhat is your choice? ");
        }
    }
}