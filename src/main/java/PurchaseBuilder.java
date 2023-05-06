public class PurchaseBuilder {
    private String title;
    private int count;

    public PurchaseBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public PurchaseBuilder setCount(int count) {
        this.count = count;
        return this;
    }

    public PurchaseImpl build() {
        return new PurchaseImpl(title, count);
    }
}
