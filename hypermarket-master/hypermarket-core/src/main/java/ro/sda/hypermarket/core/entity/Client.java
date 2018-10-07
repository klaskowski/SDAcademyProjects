package ro.sda.hypermarket.core.entity;

import ro.sda.hypermarket.core.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "clients", schema = "hypermarket")
public class Client extends BaseEntity {

    @Column(name = "client_type", nullable = false)
    private String type;

    @Column(name = "client_name", nullable = false, unique = true)
    private String name;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(this.getType(), client.getType()) &&
                Objects.equals(this.getName(), client.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.getType(), this.getName());
    }

    @Override
    public String toString() {
        return "Client{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
