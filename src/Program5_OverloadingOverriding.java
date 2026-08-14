// Program #5 : Method Overloading and Overriding - Justice Hub Domain

class CaseRegister {

    // ---------- Method Overloading : same name, different parameters ----------
    void registerCase(String plaintiff) {
        System.out.println("Case registered for " + plaintiff + " (Judge auto-assigned).");
    }

    void registerCase(String plaintiff, String judge) {
        System.out.println("Case registered for " + plaintiff + " with " + judge + ".");
    }

    void registerCase(String plaintiff, String judge, String caseType) {
        System.out.println("Case registered for " + plaintiff + " with " + judge
                + " | Type: " + caseType + ".");
    }

    // method to be overridden by child
    void showPriority() {
        System.out.println("Priority : Normal");
    }
}

// ---------- Method Overriding : child redefines parent method ----------
class UrgentCaseRegister extends CaseRegister {

    @Override
    void showPriority() {
        System.out.println("Priority : URGENT (Fast-Track Hearing)");
    }
}

public class Program5_OverloadingOverriding {

    public static void main(String[] args) {

        System.out.println("===== METHOD OVERLOADING =====");
        CaseRegister reg = new CaseRegister();
        reg.registerCase("Ali Khan");
        reg.registerCase("Maria Ahmed", "Justice Sarah");
        reg.registerCase("Sara Ali", "Justice Ahmed", "Criminal");

        System.out.println("\n===== METHOD OVERRIDING =====");
        CaseRegister normal = new CaseRegister();
        CaseRegister urgent = new UrgentCaseRegister();   // runtime polymorphism

        normal.showPriority();
        urgent.showPriority();   // calls the overridden version
    }
}
