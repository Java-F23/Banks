class BankAccountType {
    private final int type;
    private final String name;
    private final String features;

    public BankAccountType(int type, String name, String features) {
        this.type = type;
        this.name = name;
        this.features = features;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
