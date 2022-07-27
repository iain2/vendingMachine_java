package coins;

public enum CoinType {

    ONEPOUND(100),
    FIFTYPENCE(50),
    TWENTYPENCE(20),
    TENPENCE(10),
    FIVEPENCE(5),
    TWOPENCE(2),
    ONEPENCE(1);

    private final int value;

    CoinType(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }

}
