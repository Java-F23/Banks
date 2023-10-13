class BankAccountType {
    private int type;
    private String name;
    private String features;

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
