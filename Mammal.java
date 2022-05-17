// Lecture 1 - Day 2 - 07.03.22 - Sample of Runnable - Book Slide 36 - 22

public class Mammal extends Animal implements Runnable {
    public Mammal(String name) {
        super(name);
    }
    public void run() {
        for (int i = 0; i <100; i++) {
            System.out.println("The name of the Animal " + i + " is: " + this.getName());
        }
    }
    public static void main(String[] args) {
        Animal firstAnimal = new Mammal("Dog");
        Thread thread1 = new Thread((Runnable) firstAnimal);
        thread1.start();
        Animal secondAnimal = new Mammal("Lion");
        Thread thread2 = new Thread((Runnable) secondAnimal);
        thread2.start();
    }
}
