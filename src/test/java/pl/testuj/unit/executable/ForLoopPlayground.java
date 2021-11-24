package pl.testuj.unit.executable;

public class ForLoopPlayground {

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            System.out.println("Iterator is currently at " + i);
        }

        System.out.println("\n\n");

        for (int i=9; i>=0; i--) {
            System.out.println("Iterator is currently at " + i);
        }
    }

}
