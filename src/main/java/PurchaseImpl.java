import Interfaces.Purchase;

public class PurchaseImpl implements Purchase {
    private final String title;
    private int count;

    public PurchaseImpl(String title, int count) {
        this.title = title;
        this.count = count;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void setCount(int count) {
        this.count = count;
    }
}