
public class Coffee extends CaffeineBeverage {
    UserInputCollector userInputCollector;

    public Coffee() {
        String message = "Would you like milk and sugar with your coffee (y/n)? ";
        this.userInputCollector = new StdinUserInputCollector(message);
    }

    @Override
    void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }

    @Override
    public boolean customerWantsCondiments() {
        String answer = userInputCollector.getUserInput();

        if (answer.toLowerCase().startsWith("y")) {
            return true;
        } else {
            return false;
        }
    }
}
