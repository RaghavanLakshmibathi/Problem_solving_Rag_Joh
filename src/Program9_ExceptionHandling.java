import java.util.Scanner;

class Program9_ExceptionHandling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("===== JUSTICE HUB =====");

            System.out.print("Enter Case ID: ");
            int caseId = sc.nextInt();

            System.out.print("Enter Number of Hearing Days: ");
            int hearingDays = sc.nextInt();

            if (hearingDays <= 0) {
                throw new Exception("Hearing days must be greater than 0.");
            }

            System.out.println("\n----- Case Details -----");
            System.out.println("Case ID       : " + caseId);
            System.out.println("Hearing Days  : " + hearingDays);
            System.out.println("Status        : Pending");

        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nJustice Hub - Program Completed");
    }
}