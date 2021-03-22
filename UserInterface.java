public class UserInterface {
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
}
