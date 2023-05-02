package employeeDatabase;

public class Property {
    private Object data;

    public Property(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public String getType() {
        return data.getClass().getName();
    }
}
