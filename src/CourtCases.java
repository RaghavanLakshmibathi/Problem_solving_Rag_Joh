public class CourtCases {

    public static void main(String[] args) {

        String[] caseIds = {"C101", "C102", "C103", "C104"};
        String[] judges = {"Justice Arun", "Justice Priya", "Justice Ravi", "Justice Kumar"};

        System.out.println("Court Case Details\n");
        System.out.println(caseIds.length);

        for (int i = 0; i < caseIds.length; i++) {
            System.out.println("Case ID : " + caseIds[i]);
            System.out.println("Judge   : " + judges[i]);
            System.out.println("------------------------");
        }
    }
}