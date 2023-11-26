class BankAccountType {
    private final int type;
    private final String name;

    public BankAccountType(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
