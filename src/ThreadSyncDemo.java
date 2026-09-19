// Program 11 : Implement Thread Synchronization in Java
// Domain: Justice Hub - Court Case Management
// Many clerks register cases into ONE shared registry at the same time.
// synchronized is used so that Case IDs are never duplicated.

class CaseRegistry {

    private int caseNumber = 1001;

    // synchronized: only one clerk can register a case at a time
    synchronized void registerCase(String clerkName) {

        String caseId = "JH" + caseNumber;

        System.out.println(clerkName + " registered case with ID: " + caseId);

        caseNumber++;
    }
}

class Clerk extends Thread {

    private CaseRegistry registry;
    private String clerkName;

    Clerk(CaseRegistry registry, String clerkName) {
        this.registry = registry;
        this.clerkName = clerkName;
    }

    public void run() {

        // each clerk registers 3 cases into the shared registry
        for (int i = 0; i < 3; i++) {
            registry.registerCase(clerkName);
        }
    }
}

public class ThreadSyncDemo {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("========== JUSTICE HUB - Case Registration ==========");

        // one shared registry used by all clerks
        CaseRegistry registry = new CaseRegistry();

        Clerk clerk1 = new Clerk(registry, "Clerk A");
        Clerk clerk2 = new Clerk(registry, "Clerk B");

        clerk1.start();
        clerk2.start();

        // wait for both clerks to finish before ending the program
        clerk1.join();
        clerk2.join();

        System.out.println("All cases registered without duplicate IDs.");
    }
}
