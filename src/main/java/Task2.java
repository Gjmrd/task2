import java.util.ArrayList;


public class Task2 {
    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("missing argument");
            return;
        }
       printNumbersFor(args[0]);
    }

    public static void printNumbersFor(String name) {
        PhoneBook phoneBook = PhoneBook.getInstance();
        ArrayList<String> phoneNumbers = phoneBook.getPhoneNumbers().get(name);

        if (phoneNumbers != null && !phoneNumbers.isEmpty()) {
            for (int index = 0; index < phoneNumbers.size(); index++) {
                System.out.println(String.format("%d. %s", index + 1, phoneNumbers.get(index)));
            }
        } else {
            System.out.println("No numbers for " + name);
        }
    }
}
