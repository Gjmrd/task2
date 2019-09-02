import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


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
    public void mainWithNoNumbers() {
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