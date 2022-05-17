// Lecture 1 - Day 1 - 28.02.22 - Sample of Thread - Book Slide 35 - 21

public class NewThread extends Thread {
    // modified version of Dr. Thien
    int n = 0;
    public NewThread(int n) {
        this.n = n;
    }
    public void run() {
        System.out.println("New Thread " + n + " executing");
        for(int i = 0; i < 10; i++) {
            System.out.println("Thread " + n + " : " + i);
        }
    }
    public static void main(String[] args) {
        Thread t1 = new NewThread(2);
        Thread t2 = new NewThread(5);
        // Thread t3 = new NewThread(3);
        t1.start();
        t2.start();
        // t3.start();
    }
}