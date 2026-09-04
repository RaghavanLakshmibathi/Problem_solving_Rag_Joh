class LegalCase1 {

    String caseId;
    String plaintiffName;
    String status;

    LegalCase1(String caseId, String plaintiffName) {
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


class CourtTrial1 {

    String caseId;
    String plaintiffName;
    String status;
    String judgeName;
    String hearingDate;

    CourtTrial1(String caseId, String plaintiffName,
               String judgeName, String hearingDate) {

        this.caseId = caseId;
        this.plaintiffName = plaintiffName;
        this.status = "Pending";
        this.judgeName = judgeName;
        this.hearingDate = hearingDate;
    }

    void showCourtDetails() {
        System.out.println("Case ID    : " + caseId);
        System.out.println("Plaintiff  : " + plaintiffName);
        System.out.println("Status     : " + status);
        System.out.println("Judge      : " + judgeName);
        System.out.println("Hearing    : " + hearingDate);
    }
}


class AppealCase1 {

    String caseId;
    String plaintiffName;
    String status;
    String judgeName;
    String hearingDate;
    String appealReason;
    String higherCourt;

    AppealCase1(String caseId, String plaintiffName,
               String judgeName, String hearingDate,
               String appealReason, String higherCourt) {

        this.caseId = caseId;
        this.plaintiffName = plaintiffName;
        this.status = "Pending";
        this.judgeName = judgeName;
        this.hearingDate = hearingDate;
        this.appealReason = appealReason;
        this.higherCourt = higherCourt;
    }

    void showAppealDetails() {
        System.out.println("Case ID     : " + caseId);
        System.out.println("Plaintiff   : " + plaintiffName);
        System.out.println("Status      : " + status);
        System.out.println("Judge       : " + judgeName);
        System.out.println("Hearing     : " + hearingDate);
        System.out.println("Appeal For  : " + appealReason);
        System.out.println("Higher Court: " + higherCourt);
    }
}


public class Program3_without_inheritance {

    public static void main(String[] args) {

        System.out.println("===== LEGAL CASE =====");

        LegalCase1 legal = new LegalCase1(
                "JH1001",
                "Ali Khan"
        );

        legal.showCase();


        System.out.println("\n===== COURT TRIAL =====");

        CourtTrial1 court = new CourtTrial1(
                "JH1002",
                "Maria Ahmed",
                "Justice Sarah",
                "10 Days From Today"
        );

        court.showCourtDetails();


        System.out.println("\n===== APPEAL CASE =====");

        AppealCase1 appeal = new AppealCase1(
                "JH1003",
                "John Smith",
                "Justice Ali",
                "20 Days From Today",
                "Unfair Verdict",
                "Supreme Court"
        );

        appeal.showAppealDetails();
    }
}