class Supplies {
    UserInterface ui = new UserInterface();
    int amount;

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
        enum FoodRationSize {
            BAREBONES,
            MEAGER,
            FILLING
        }
        
        public Food (int quantityOfFood) {
            this.amount = quantityOfFood;
            rationSize = FoodRationSize.FILLING;
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