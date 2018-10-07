package ro.sda.hypermarket.core.entity;

import ro.sda.hypermarket.core.base.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "purchased_products", schema = "hypermarket")
public class PurchasedProduct extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "product_amount", nullable = false)
    private int productAmount;

    public Purchase getPurchase() {
        return this.purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductAmount() {
        return this.productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchasedProduct)) return false;
        PurchasedProduct that = (PurchasedProduct) o;
        return this.getProductAmount() == that.getProductAmount() &&
                Objects.equals(this.getPurchase(), that.getPurchase()) &&
                Objects.equals(this.getProduct(), that.getProduct());
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.getPurchase(), this.getProduct(), this.getProductAmount());
    }

    @Override
    public String toString() {
        return "PurchasedProduct{" +
                "purchase=" + purchase +
                ", product=" + product +
                ", productAmount=" + productAmount +
                '}';
    }
}
