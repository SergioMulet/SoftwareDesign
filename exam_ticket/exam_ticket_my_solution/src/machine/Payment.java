package machine;

public interface Payment {
    boolean pay(Machine machine, double amount);
    String getName();
}
