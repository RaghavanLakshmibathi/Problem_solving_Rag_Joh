import java.util.*;
import java.util.stream.*;

class Program8_StreamAPI {

    public static void main(String[] args) {

        List<String> cases = Arrays.asList(
                "Murder Case",
                "Property Case",
                "Cyber Crime Case",
                "Murder Case",
                "Family Case"
        );

        System.out.println("===== JUSTICE HUB =====");

        // 1. filter() - Find cases containing "Case"
        System.out.println("\nCases containing 'Murder':");
        cases.stream()
                .filter(c -> c.contains("Murder"))
                .forEach(System.out::println);

        // 2. map() - Convert case names to uppercase
        System.out.println("\nCase Names in Uppercase:");
        cases.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // 3. distinct() - Remove duplicate cases
        System.out.println("\nUnique Cases:");
        cases.stream()
                .distinct()
                .forEach(System.out::println);

        // 4. count() - Count total cases
        long totalCases = cases.stream().count();
        System.out.println("\nTotal Cases: " + totalCases);

        // 5. sorted() - Sort cases alphabetically
        System.out.println("\nSorted Cases:");
        cases.stream()
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}