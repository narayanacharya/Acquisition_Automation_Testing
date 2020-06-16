package common;

/**
 * Model a simple field that consists of just a label and data, and has a name
 */
public class DataField {
    String name;
    String label;
    String data;

    public DataField(String name, String label, String data) {
        this.name = name;
        this.label = label;
        this.data = data;
    }

    public DataField setName(String name) {
        this.name = name;
        return this;
    }

    public DataField setLabel(String label) {
        this.label = label;
        return this;
    }

    public DataField setData(String data) {
        this.data = data;
        return this;
    }
}
