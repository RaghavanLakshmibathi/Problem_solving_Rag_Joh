// Program #7 : String Pool Demonstration - Justice Hub Domain

public class Program7_StringPool {

    public static void main(String[] args) {

        // ---------- String literals share the same pool object ----------
        String judge1 = "Justice Sarah";
        String judge2 = "Justice Sarah";     // reuses the SAME pooled object

        System.out.println("===== String Literals (Pool) =====");
        System.out.println("judge1 == judge2 : " + (judge1 == judge2));        // true (same reference)
        System.out.println("judge1.equals(judge2) : " + judge1.equals(judge2)); // true (same value)

        // ---------- 'new' always creates a separate heap object ----------
        String judge3 = new String("Justice Sarah");

        System.out.println("\n===== new String() (Heap) =====");
        System.out.println("judge1 == judge3 : " + (judge1 == judge3));         // false (different object)
        System.out.println("judge1.equals(judge3) : " + judge1.equals(judge3)); // true (same value)

        // ---------- intern() pulls the value back to the pool ----------
        String judge4 = judge3.intern();

        System.out.println("\n===== intern() =====");
        System.out.println("judge1 == judge4 : " + (judge1 == judge4));         // true (back in pool)

        System.out.println("\nLesson: use .equals() to compare case data / judge names, never ==");
    }
}
