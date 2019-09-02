import java.util.ArrayList;


public class Task2 {
    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("missing argument");
            return;
        }
        PhoneBook phoneBook = PhoneBook.getInstance();
        String input = args[0];
        ArrayList<String> phoneNumbers = phoneBook.getPhoneNumbers().get(input);

        if (phoneNumbers != null && phoneNumbers.size() > 0) {
            for (int index = 1; index <= phoneNumbers.size(); index++) {
                System.out.println(String.format("%d. %s", index, phoneNumbers.get(index - 1)));
            }
        } else {
            System.out.println("No numbers for " + input);
        }
    }
}
