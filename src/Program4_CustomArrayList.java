// Program #4 : Custom ArrayList using Multilevel Inheritance - Justice Hub Domain
// Interface CustomCollection -> Abstract Class CustomList -> Class CustomArrayList

// ---------- Interface ----------
interface CustomCollection {
    void add(String caseId);
    String get(int index);
    boolean remove(String caseId);
    int size();
    boolean isEmpty();
    boolean contains(String caseId);
    void display();
}

// ---------- Abstract Class ----------
abstract class CustomList implements CustomCollection {

    protected String[] data = new String[5];
    protected int count = 0;

    // common reusable logic
    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean contains(String caseId) {
        for (int i = 0; i < count; i++) {
            if (data[i].equals(caseId)) {
                return true;
            }
        }
        return false;
    }

    // abstract methods forced onto the child class
    public abstract void add(String caseId);
    public abstract boolean remove(String caseId);
}

// ---------- Concrete Class ----------
class CustomArrayList extends CustomList {

    // grow the array when full
    private void ensureCapacity() {
        if (count == data.length) {
            String[] bigger = new String[data.length * 2];
            for (int i = 0; i < count; i++) {
                bigger[i] = data[i];
            }
            data = bigger;
        }
    }

    public void add(String caseId) {
        ensureCapacity();
        data[count++] = caseId;
    }

    public String get(int index) {
        if (index < 0 || index >= count) {
            System.out.println("Invalid Index.");
            return null;
        }
        return data[index];
    }

    public boolean remove(String caseId) {
        for (int i = 0; i < count; i++) {
            if (data[i].equals(caseId)) {
                for (int j = i; j < count - 1; j++) {
                    data[j] = data[j + 1];
                }
                data[--count] = null;
                return true;
            }
        }
        return false;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("No Case IDs Stored.");
            return;
        }
        System.out.print("Case IDs : ");
        for (int i = 0; i < count; i++) {
            System.out.print(data[i] + (i < count - 1 ? ", " : ""));
        }
        System.out.println();
    }
}

public class Program4_CustomArrayList {

    public static void main(String[] args) {

        CustomArrayList caseList = new CustomArrayList();

        caseList.add("JH1001");
        caseList.add("JH1002");
        caseList.add("JH1003");
        caseList.add("JH1004");
        caseList.add("JH1005");
        caseList.add("JH1006");   // triggers auto-grow

        System.out.println("Size            : " + caseList.size());
        caseList.display();

        System.out.println("Get index 2     : " + caseList.get(2));
        System.out.println("Contains JH1003 : " + caseList.contains("JH1003"));

        System.out.println("Remove JH1002   : " + caseList.remove("JH1002"));
        caseList.display();

        System.out.println("Is Empty        : " + caseList.isEmpty());
        System.out.println("Final Size      : " + caseList.size());
    }
}
