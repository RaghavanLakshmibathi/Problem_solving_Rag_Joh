// Program 10 : Implement Threads in Java
// Domain: Justice Hub - Court Case Management
// Each Judge runs on its own thread and hears their assigned cases.

class Judge extends Thread {

    private String judgeName;
    private int caseCount;

    Judge(String judgeName, int caseCount) {
        this.judgeName = judgeName;
        this.caseCount = caseCount;
    }

    // Code that runs when the thread starts
    public void run() {

        for (int i = 1; i <= caseCount; i++) {

            System.out.println(judgeName + " is hearing case " + i);

            try {
                // pause to simulate the time taken to hear a case
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(judgeName + " hearing interrupted.");
            }
        }

        System.out.println(judgeName + " has finished all hearings.");
    }
}

public class ThreadDemo {

    public static void main(String[] args) {

        System.out.println("========== JUSTICE HUB - Court Hearings ==========");

        // Create judge threads
        Judge judge1 = new Judge("Justice Sarah", 3);
        Judge judge2 = new Judge("Justice Ahmed", 3);
        Judge judge3 = new Judge("Justice Ali", 3);

        // Start the threads - all judges hear cases at the same time
        judge1.start();
        judge2.start();
        judge3.start();
    }
}
