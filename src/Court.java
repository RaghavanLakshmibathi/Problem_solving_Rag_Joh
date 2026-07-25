public class Court {

    String judgeName;
    String caseId;
    String lawyerName;
    String courtLocation;

    void displayDetails() {
        System.out.println("Judge Name : " + judgeName);
        System.out.println("Case ID    : " + caseId);
        System.out.println("Lawyer     : " + lawyerName);
        System.out.println("Location   : " + courtLocation);
    }

    public static void main(String[] args) {

        Court case1 = new Court();

        case1.judgeName = "Justice Arun";
        case1.caseId = "C101";
        case1.lawyerName = "Rahul Sharma";
        case1.courtLocation = "Chennai High Court";

        case1.displayDetails();
    }
}