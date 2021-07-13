package kata;

public class Name {
    private String name;

    public Name(String name) {
        this.name = name;
    }

    public boolean is(String name) {
        return this.name.equals(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
