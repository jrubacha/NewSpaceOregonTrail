class Supplies {
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
    }
}