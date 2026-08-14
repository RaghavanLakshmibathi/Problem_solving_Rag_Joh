// Program #6 : Built-in Collections - Justice Hub Domain

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Program6_Collections {

    public static void main(String[] args) {

        // ---------- ArrayList : ordered list of registered case IDs ----------
        System.out.println("===== ArrayList (Registered Cases) =====");
        ArrayList<String> cases = new ArrayList<>();
        cases.add("JH1001");
        cases.add("JH1002");
        cases.add("JH1003");
        cases.remove("JH1002");
        System.out.println("Cases     : " + cases);
        System.out.println("First Case: " + cases.get(0));
        System.out.println("Total     : " + cases.size());

        // ---------- HashMap : map each case to its assigned judge ----------
        System.out.println("\n===== HashMap (Case -> Judge) =====");
        HashMap<String, String> caseJudge = new HashMap<>();
        caseJudge.put("JH1001", "Justice Sarah");
        caseJudge.put("JH1003", "Justice Ahmed");
        System.out.println("Judge of JH1001 : " + caseJudge.get("JH1001"));
        System.out.println("All Assignments : " + caseJudge);

        // ---------- HashSet : unique judges (no duplicates) ----------
        System.out.println("\n===== HashSet (Unique Judges) =====");
        HashSet<String> judges = new HashSet<>();
        judges.add("Justice Sarah");
        judges.add("Justice Ahmed");
        judges.add("Justice Sarah");   // duplicate ignored
        System.out.println("Unique Judges   : " + judges);
        System.out.println("Total Judges    : " + judges.size());
    }
}
