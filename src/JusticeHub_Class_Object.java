import java.util.Random;
import java.util.Scanner;

class CourtCase1 {

    String caseId;
    String plaintiffName;
    String caseType;
    String judgeName;
    String hearingDate;
    String status;

    CourtCase1(String caseId, String plaintiffName, String caseType,
              String judgeName, String hearingDate) {

        this.caseId = caseId;
        this.plaintiffName = plaintiffName;
        this.caseType = caseType;
        this.judgeName = judgeName;
        this.hearingDate = hearingDate;
        this.status = "Pending";
    }

    void display() {

        System.out.println("\n------------------------------");
        System.out.println("Case ID       : " + caseId);
        System.out.println("Plaintiff     : " + plaintiffName);
        System.out.println("Case Type     : " + caseType);
        System.out.println("Judge         : " + judgeName);
        System.out.println("Hearing Date  : " + hearingDate);
        System.out.println("Status        : " + status);
    }
}

public class JusticeHub_Class_Object {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        CourtCase[] cases = new CourtCase[100];

        String[] judges = {
                "Justice Sarah",
                "Justice Ahmed",
                "Justice Ali",
                "Justice Maria"
        };

        int[] workload = {0,0,0,0};

        int count = 0;
        int caseNumber = 1001;

        while(true){

            System.out.println("\n========== JUSTICE HUB ==========");
            System.out.println("1. Register New Case");
            System.out.println("2. View All Cases");
            System.out.println("3. Update Case Status");
            System.out.println("4. Exit");

            System.out.print("Enter Choice : ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:

                    System.out.print("Plaintiff Name : ");
                    String name = sc.nextLine();

                    System.out.print("Case Type (Civil/Criminal/Family/Property): ");
                    String type = sc.nextLine();

                    String caseId = "JH" + caseNumber++;

                    int min = workload[0];

                    for(int i=1;i<workload.length;i++){

                        if(workload[i] < min){

                            min = workload[i];

                        }

                    }

                    int[] available = new int[4];
                    int availableCount = 0;

                    for(int i=0;i<workload.length;i++){

                        if(workload[i]==min){

                            available[availableCount++] = i;

                        }

                    }

                    int selected = available[random.nextInt(availableCount)];

                    workload[selected]++;

                    String hearingDate = (random.nextInt(30)+1) + " Days From Today";

                    cases[count] = new CourtCase(
                            caseId,
                            name,
                            type,
                            judges[selected],
                            hearingDate
                    );

                    count++;

                    System.out.println("\nCase Registered Successfully");
                    System.out.println("Case ID : " + caseId);
                    System.out.println("Judge Assigned : " + judges[selected]);
                    System.out.println("Hearing Date : " + hearingDate);

                    break;

                case 2:

                    if(count==0){

                        System.out.println("No Cases Registered.");

                    }
                    else{

                        for(int i=0;i<count;i++){

                            cases[i].display();

                        }

                    }

                    break;

                case 3:

                    if(count==0){

                        System.out.println("No Cases Available.");
                        break;

                    }

                    System.out.print("Enter Case ID : ");
                    String search = sc.nextLine();

                    boolean found = false;

                    for(int i=0;i<count;i++){

                        if(cases[i].caseId.equals(search)){

                            found = true;

                            System.out.println("Current Status : " + cases[i].status);

                            System.out.println("1. Pending");
                            System.out.println("2. Hearing");
                            System.out.println("3. Closed");

                            int option = sc.nextInt();

                            if(option==1){

                                cases[i].status="Pending";

                            }
                            else if(option==2){

                                cases[i].status="Hearing";

                            }
                            else if(option==3){

                                cases[i].status="Closed";

                                for(int j=0;j<judges.length;j++){

                                    if(cases[i].judgeName.equals(judges[j])){

                                        workload[j]--;
                                        break;

                                    }

                                }

                            }
                            else{

                                System.out.println("Invalid Status");

                            }

                            System.out.println("Status Updated.");

                            break;

                        }

                    }

                    if(!found){

                        System.out.println("Case ID Not Found.");

                    }

                    sc.nextLine();

                    break;

                case 4:

                    System.out.println("Thank You For Using Justice Hub");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice.");
            }
        }
    }
}