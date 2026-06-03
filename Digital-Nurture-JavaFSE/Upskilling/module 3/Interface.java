interface Playable {
    void play();
}
class Guitar implements Playable {
    @Override
    public void play() {
        System.out.println("Guitar");
    }
}
class Piano implements Playable {
    @Override
    public void play() {
        System.out.println("Piano");
    }
}
public class Interface {
    public static void main(String[] args) {
        Playable guitar = new Guitar();
        Playable piano = new Piano();
        guitar.play();
        piano.play();
    }
}