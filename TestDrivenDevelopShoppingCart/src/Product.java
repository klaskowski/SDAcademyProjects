import java.util.Objects;

public class Product {
    private String name;
    private double value;

    public Product(String name, double value){
        this.name = name;
        this.value = value;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setValue(double value){
        this.value = value;
    }

    public double getValue(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getName(), product.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getValue());
    }
}
