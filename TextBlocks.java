import java.util.Scanner;

public class TextBlocks {
    UserInterface ui = new UserInterface();
    Scanner keyboard = new Scanner(System.in);
    public void getCraftSelection(){
        SpaceCraft firstCraft;
        switch (keyboard.nextInt()) {
            case 1:
                firstCraft = new SpaceCraft("Saturn V", firstCraft.speed.SLOW, firstCraft.quality.POOR, 3, 1000, firstCraft.tankSize.SMALL);
        }
    }
}
