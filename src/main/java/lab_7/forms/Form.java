package lab_7.forms;

public class Form {
    private static int counter;
    private String color;

    public Form() {
        counter++;
        color = "white";
    }

    public Form(String color) {
        counter++;
        this.color = color;
    }

    public static int getInstanceCount() {
        return counter;
    }

    public float getArea() {
        return 0;
    }

    public String toString() {
        return "This form has the color " + color;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Form) {
            Form f = (Form) obj;
            if (this.color == null && f.color == null) {
                return true;
            } else if (this.color != null && f.color != null && this.color.compareTo(f.color) == 0) {
                return true;
            }
        }
        return false;
    }
}
