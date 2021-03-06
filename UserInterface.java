import java.util.*;
public class UserInterface {
    Scanner keyboard = new Scanner(System.in);
    public void print(String word) {
        System.out.print(word);
    }
    public void println(String word) {
        System.out.println(word);
    }
    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void printpad15(String word) {
        System.out.printf("%15s", word);
    }
    public void printpad35(String word) {
        System.out.printf("%35s", word);
    }

    public void pressEnter(){
        print("\n< Press ENTER to continue >");
        keyboard.nextLine();
    }

    public boolean areWeAlive(Supplies supplies, SpaceCraft craft, Crew crew, int days) {
        
        return true;
    }
}
