import java.util.Arrays;

interface CustomCollection {

    void add(String caseName);

    void remove(int index);

    String get(int index);

    int size();

    void display();
}

abstract class CustomList implements CustomCollection {

    protected String[] data = new String[5];
    protected int count = 0;

    void increaseSize() {

        data = Arrays.copyOf(data, data.length * 2);
    }
}


class CustomArrayList extends CustomList {

    @Override
    public void add(String caseName) {

        if (count == data.length) {
            increaseSize();
        }

        data[count] = caseName;
        count++;
    }

    @Override
    public void remove(int index) {

        if (index < 0 || index >= count) {
            System.out.println("Invalid index");
            return;
        }

        for (int i = index; i < count - 1; i++) {
            data[i] = data[i + 1];
        }

        count--;
    }

    @Override
    public String get(int index) {

        if (index < 0 || index >= count) {
            return "Invalid index";
        }

        return data[index];
    }

    @Override
    public int size() {

        return count;
    }

    @Override
    public void display() {

        for (int i = 0; i < count; i++) {
            System.out.println(i + " : " + data[i]);
        }
    }
}


public class Program4_CustomArrayList {

    public static void main(String[] args) {

        CustomArrayList cases = new CustomArrayList();

        System.out.println("===== JUSTICE HUB =====");

        // Add cases
        cases.add("Murder Case");
        cases.add("Property Case");
        cases.add("Cyber Crime Case");
        cases.add("Family Case");

        System.out.println("\nAll Cases:");
        cases.display();

        // Get a case
        System.out.println("\nCase at index 1:");
        System.out.println(cases.get(1));

        // Size
        System.out.println("\nTotal Cases: " + cases.size());

        // Remove a case
        cases.remove(2);

        System.out.println("\nAfter Removing Case:");
        cases.display();

        System.out.println("\nTotal Cases: " + cases.size());
    }
}