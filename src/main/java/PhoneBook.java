import java.util.ArrayList;
import java.util.HashMap;

class PhoneBook {
    private static PhoneBook instance;
    private HashMap<String, ArrayList<String>> phoneNumbers;

    private PhoneBook () {
        phoneNumbers = new HashMap<String, ArrayList<String>>();
        phoneNumbers.put("Иванов И.И.", new ArrayList<String>() {{
            add("+8 800 2000 500");
            add("+8 800 200 600");
        }});

        phoneNumbers.put("Петров П.П.", new ArrayList<String>() {{
            add("+8 800 2000 700");
        }});

        phoneNumbers.put("Сидоров С.С.", new ArrayList<String>() {{
            add("+8 800 2000 800");
            add("+8 800 2000 900");
            add("+8 800 2000 000");
        }});
    }

    static PhoneBook getInstance() {
        if (instance == null) {
            instance = new PhoneBook();
        }
        return instance;
    }

    HashMap<String, ArrayList<String>> getPhoneNumbers () {
        return phoneNumbers;
    }
}
