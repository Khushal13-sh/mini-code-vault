import java.util.concurrent.Semaphore;

/*
 * add solution for print in order
 */

/**
 * Problem: Print in Order
 * Difficulty: Easy
 *
 * Description:
 * Three different threads call first(), second(), and third().
 *
 * The threads may execute in any order, but we must ensure that:
 *
 * first()  -> executes first
 * second() -> executes after first()
 * third()  -> executes after second()
 *
 * The goal is to print:
 * "firstsecondthird"
 *
 * regardless of the order in which the threads are scheduled.
 *
 * Key Insight:
 * - We can use Semaphore to control the execution order.
 * - second() waits until first() is completed.
 * - third() waits until second() is completed.
 *
 * Approach:
 * - Create a Semaphore for second() with 0 permits.
 * - Create a Semaphore for third() with 0 permits.
 * - first() prints first and releases secondSemaphore.
 * - second() waits using acquire(), prints second,
 *   and releases thirdSemaphore.
 * - third() waits using acquire() and then prints third.
 *
 * Why this works:
 * - Initially, both semaphores have 0 permits.
 * - Therefore, second() cannot execute until first() releases
 *   a permit.
 * - Similarly, third() cannot execute until second() releases
 *   a permit.
 *
 * Time Complexity: O(1)
 *
 * Space Complexity: O(1)
 */
public class PrintInOrder {

    private final Semaphore secondSemaphore = new Semaphore(0);
    private final Semaphore thirdSemaphore = new Semaphore(0);

    public PrintInOrder() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // Print "first".
        printFirst.run();

        // Allow second() to execute.
        secondSemaphore.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // Wait until first() is completed.
        secondSemaphore.acquire();

        // Print "second".
        printSecond.run();

        // Allow third() to execute.
        thirdSemaphore.release();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // Wait until second() is completed.
        thirdSemaphore.acquire();

        // Print "third".
        printThird.run();
    }

    public static void main(String[] args) throws InterruptedException {

        PrintInOrder obj = new PrintInOrder();

        Runnable printFirst = () -> System.out.print("first");
        Runnable printSecond = () -> System.out.print("second");
        Runnable printThird = () -> System.out.print("third");

        // Threads are intentionally started in a different order
        // to demonstrate that the output remains ordered.
        Thread thread3 = new Thread(() -> {
            try {
                obj.third(printThird);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                obj.second(printSecond);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread thread1 = new Thread(() -> {
            try {
                obj.first(printFirst);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Start in random order.
        thread3.start();
        thread2.start();
        thread1.start();

        // Wait for all threads to finish.
        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println();
    }
}