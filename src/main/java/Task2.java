import java.lang.reflect.Array;
import java.util.ArrayList;


public class Task2 {
    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("missing argument");
            return;
        }

       ArrayList numbers = getNumbersFor(args[0]);
       if (numbers == null || numbers.isEmpty()) {
           System.out.println("No numbers for " + args[0]);
           return;
       }

       for (int index = 0; index < numbers.size(); index ++) {
           System.out.println(String.format("%d. %s", index + 1, numbers.get(index)));
       }
    }

    public static ArrayList<String> getNumbersFor(String name) {
        return PhoneBook.getInstance().getPhoneNumbers().get(name);
    }
}
