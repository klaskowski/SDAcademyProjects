package ro.sda.hypermarket.core.entity;

import ro.sda.hypermarket.core.base.BaseEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "products", schema = "hypermarket")
public class Product extends BaseEntity {

    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(name = "product_description")
    private String description;

    @Column(name = "product_code", nullable = false, unique = true)
    private String code;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToMany(mappedBy = "product")
    private List<Stock> stocks;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Supplier getSupplier() {
        return this.supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(this.getName(), product.getName()) &&
                Objects.equals(this.getDescription(), product.getDescription()) &&
                Objects.equals(this.getCode(), product.getCode()) &&
                Objects.equals(this.getCategory(), product.getCategory()) &&
                Objects.equals(this.getSupplier(), product.getSupplier());
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.getName(), this.getDescription(), this.getCode(), this.getCategory(), this.getSupplier());
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                ", category=" + category +
                ", supplier=" + supplier +
                '}';
    }
}
