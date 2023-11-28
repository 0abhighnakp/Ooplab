import java.util.Random;

class NumberGenerator extends Thread {
    public void run() {
        Random random = new Random();
        while (true) {
            int number = random.nextInt(100); // Generating random integers between 0 and 99
            System.out.println("Generated number: " + number);

            if (number % 2 == 0) {
                ThreadSquare threadSquare = new ThreadSquare(number);
                threadSquare.start();
            } else {
                ThreadCube threadCube = new ThreadCube(number);
                threadCube.start();
            }

            try {
                Thread.sleep(1000); // Wait for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadSquare extends Thread {
    private int number;

    public ThreadSquare(int number) {
        this.number = number;
    }

    public void run() {
        System.out.println("Square of " + number + " is: " + (number * number));
    }
}

class ThreadCube extends Thread {
    private int number;

    public ThreadCube(int number) {
        this.number = number;
    }

    public void run() {
        System.out.println("Cube of " + number + " is: " + (number * number * number));
    }
}

public class MultiThreadProgram {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();
        numberGenerator.start();
    }
}
