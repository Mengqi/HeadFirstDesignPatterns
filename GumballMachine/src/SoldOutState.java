
public class SoldOutState implements State {
    private GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert a quarter, the machine is sold out");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You can't eject, you haven't insert a coin yet");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there are no gumballs");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first");
    }

    @Override
    public void refill(int numberGumballs) {
        System.out.println("Refill gumballs");
        if (numberGumballs > 0) {
            gumballMachine.setCount(numberGumballs);
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        }
    }
}
