package helpers;

import java.io.IOException;

public class ConsoleHelper {
    public final static void clearConsole() throws IOException {
        final String os = System.getProperty("os.name");

        if (os.contains("Windows")) {
            Runtime.getRuntime().exec("cls");
        } else {
            Runtime.getRuntime().exec("clear");
        }
    }
}
