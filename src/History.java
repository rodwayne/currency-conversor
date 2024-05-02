public class History {
    private static int index = 1;
    private int recordIndex;
    private int option;
    private double amount;
    private String baseCode;
    private String targetCode;
    private double rate;
    private double result;

    public History(int option, double amount, String baseCode, String targetCode, double rate, double result) {
        this.recordIndex = index++;
        this.option = option;
        this.amount = amount;
        this.baseCode = baseCode;
        this.targetCode = targetCode;
        this.rate = rate;
        this.result = result;
    }

    @Override
    public String toString() {
        return String.format("%d. $%.2f [%s] equivale a $%.2f [%s]", recordIndex, amount, baseCode, result, targetCode);
    }
}
