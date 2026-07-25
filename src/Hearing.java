class Hearing {

    String caseId;
    String judgeName;
    String hearingDate;

    Hearing() {
        System.out.println("Court Hearing Created");
    }

    Hearing(String caseId) {
        this.caseId = caseId;
        System.out.println("Case ID : " + caseId);
    }

    Hearing(String caseId, String judgeName, String hearingDate) {
        this.caseId = caseId;
        this.judgeName = judgeName;
        this.hearingDate = hearingDate;

        System.out.println("Case ID      : " + caseId);
        System.out.println("Judge        : " + judgeName);
        System.out.println("Hearing Date : " + hearingDate);
    }

    public static void main(String[] args) {

        Hearing h1 = new Hearing();

        Hearing h2 = new Hearing("C205");

        Hearing h3 = new Hearing("C310", "Justice Meena", "28-07-2026");
    }
}