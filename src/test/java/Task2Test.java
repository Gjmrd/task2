import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;


public class Task2Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final String lineSeparator = System.getProperty("line.separator");

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void main() {
        String[] args = new String[] {"Иванов И.И."};
        Task2.main(args);
        Assert.assertEquals(String.format("1. +8 800 2000 500%s2. +8 800 200 600%s", lineSeparator, lineSeparator), outContent.toString());
    }

    @Test
    public void getNumbersFor() {
        ArrayList<String> numbers = Task2.getNumbersFor("Иванов И.И.");
        ArrayList<String> expected = new ArrayList<String>() {{
            add("+8 800 2000 500");
            add("+8 800 200 600");
        }};

        Assert.assertEquals(numbers, expected);
    }

    @Test
    public void noNumbers() {
        String[] args = new String[] {"Кабачков К.К."};
        Task2.main(args);
        Assert.assertEquals(String.format("No numbers for Кабачков К.К.%s", lineSeparator), outContent.toString());
    }

    @Test
    public void mainWithNoArgs() {
        String[] args = new String[]{};
        Task2.main(args);
        Assert.assertEquals(String.format("missing argument%s", lineSeparator), outContent.toString());
    }

}