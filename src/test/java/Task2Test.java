import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class Task2Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

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
        Assert.assertEquals("1. +8 800 2000 500\r\n2. +8 800 200 600\r\n", outContent.toString());
    }

    @Test
    public void mainWithNoNumbers() {
        String[] args = new String[] {"Кабачков К.К."};
        Task2.main(args);
        Assert.assertEquals("No numbers for Кабачков К.К.\r\n", outContent.toString());
    }


}