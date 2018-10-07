package ro.sda.hypermarket.core.entity;

import ro.sda.hypermarket.commons.util.Validator;
import ro.sda.hypermarket.core.base.BaseEntity;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "categories", schema = "hypermarket")
public class Category extends BaseEntity {

    @Column(name = "category_name", nullable = false)
    private String name;

    @Column(name = "category_description")
    private String description;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if(Validator.hasText(name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Field can't be blank");
        }
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return Objects.equals(this.getName(), category.getName()) &&
                Objects.equals(this.getDescription(), category.getDescription());
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.getName(), this.getDescription());
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
