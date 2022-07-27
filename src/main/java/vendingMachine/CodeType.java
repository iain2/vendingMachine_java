package vendingMachine;

public enum CodeType {

    A1(0),
    A2(1),
    A3(2),
    ;

    private final int value;

    CodeType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
