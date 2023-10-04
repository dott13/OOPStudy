package helpers;

import java.io.IOException;

public class ConsoleHelper {
    public final static void clearConsole() throws InterruptedException, IOException {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
}
