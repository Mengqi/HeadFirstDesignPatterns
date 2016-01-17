import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StdinUserInputCollector implements UserInputCollector {
    String message;

    public StdinUserInputCollector(String message) {
        this.message = message;
    }

    @Override
    public String getUserInput() {
        String answer = null;

        System.out.print(message);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException ioe) {
            System.err.println("IO error trying to read your answer");
        }

        if (answer == null) {
            answer = "no";
        }

        return answer;
    }

}
