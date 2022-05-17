// Lecture 1 - Day 2 - 07.03.22 - Sample of Join - Book Slide 36 - 22

public class Fib extends Thread {
    private int x;
    public int answer;
    public Fib(int x) {
        this.x = x;
    }
    public void run() {
        if (x <=2)
            answer = 1;
        else {
            try {
                Fib f1 = new Fib(x-1);
                Fib f2 = new Fib(x-2);
                f1.start();
                f2.start();
                f1.join();
                f2.join();
                answer = f1.answer + f2.answer;
            }
            catch (InterruptedException ex) { }
        }
    }
    public static void main(String[] args) {
        try{
            Fib f = new Fib(6);
            f.run();
            f.join();
            System.out.println("The answer of this Fibonacci is " + f.answer);
        }
        catch(Exception ex) {
            // Print when there is an error
            System.err.println("usage: java Fib NUMBER");
        }
    }
}
