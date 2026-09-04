class LegalCase {

    String caseId;
    String plaintiffName;
    String status;

    LegalCase(String caseId, String plaintiffName) {
        this.caseId = caseId;
        this.plaintiffName = plaintiffName;
        this.status = "Pending";
    }

    void showCase() {
        System.out.println("Case ID    : " + caseId);
        System.out.println("Plaintiff  : " + plaintiffName);
        System.out.println("Status     : " + status);
    }
}

class CourtTrial extends LegalCase {

    String judgeName;
    String hearingDate;

    CourtTrial(String caseId, String plaintiffName, String judgeName, String hearingDate) {
        super(caseId, plaintiffName);
        this.judgeName = judgeName;
        this.hearingDate = hearingDate;
    }

    void showCourtDetails() {
        showCase();
        System.out.println("Judge      : " + judgeName);
        System.out.println("Hearing    : " + hearingDate);
    }
}

class AppealCase extends CourtTrial {

    String appealReason;
    String higherCourt;

    AppealCase(String caseId, String plaintiffName, String judgeName,
               String hearingDate, String appealReason, String higherCourt) {
        super(caseId, plaintiffName, judgeName, hearingDate);   // reusing CourtTrial constructor
        this.appealReason = appealReason;
        this.higherCourt = higherCourt;
    }

    void showAppealDetails() {
        showCourtDetails();
        System.out.println("Appeal For : " + appealReason);
        System.out.println("Higher Court: " + higherCourt);
    }
}

public class Program3_Inheritance {

    public static void main(String[] args) {

        System.out.println("SIMPLE INHERITANCE (CourtTrial extends LegalCase)");
        CourtTrial court = new CourtTrial("JH1001", "Ali Khan", "Justice Sarah", "10 Days From Today");
        court.showCourtDetails();

        System.out.println("\n===== MULTILEVEL INHERITANCE (AppealCase extends CourtTrial extends LegalCase) =====");
        AppealCase appeal = new AppealCase("JH1002", "Maria Ahmed", "Justice Ali",
                "20 Days From Today", "Unfair Verdict", "Supreme Court");
        appeal.showAppealDetails();

        System.out.println("\n===== CODE REUSABILITY =====");
        System.out.println("caseId, plaintiffName, status  -> written ONCE in LegalCase, reused by all.");
        System.out.println("showCase()                      -> written ONCE, reused via showCourtDetails() & showAppealDetails().");
    }
}
