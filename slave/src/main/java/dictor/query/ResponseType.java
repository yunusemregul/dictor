package dictor.query;

public enum ResponseType {
    ERROR("-"),
    TEXT("+"),
    INTEGER(":");

    private final String textValue;

    ResponseType(String textValue) {
        this.textValue = textValue;
    }

    public String toString() {
        return this.textValue;
    }
}
