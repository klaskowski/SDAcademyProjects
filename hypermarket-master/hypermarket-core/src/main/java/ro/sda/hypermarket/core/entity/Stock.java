package ro.sda.hypermarket.core.entity;

import ro.sda.hypermarket.core.base.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "stocks", schema = "hypermaket")
public class Stock extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "stock_amount", nullable = false)
    private int stockAmount;

    @Column(name = "batch_no", nullable = false)
    private String batchNo;

    @Column(name = "acquisition_cost", nullable = false)
    private double acquisitionCost;

    @Column(name = "selling_cost", nullable = false)
    private double sellingCost;

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getStockAmount() {
        return this.stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public String getBatchNo() {
        return this.batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public double getAcquisitionCost() {
        return this.acquisitionCost;
    }

    public void setAcquisitionCost(double acquisitionCost) {
        this.acquisitionCost = acquisitionCost;
    }

    public double getSellingCost() {
        return this.sellingCost;
    }

    public void setSellingCost(double sellingCost) {
        this.sellingCost = sellingCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock)) return false;
        Stock stock = (Stock) o;
        return this.getStockAmount() == stock.getStockAmount() &&
                Double.compare(stock.getAcquisitionCost(), this.getAcquisitionCost()) == 0 &&
                Double.compare(stock.getSellingCost(), this.getSellingCost()) == 0 &&
                Objects.equals(this.getProduct(), stock.getProduct()) &&
                Objects.equals(this.getBatchNo(), stock.getBatchNo());
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.getProduct(), this.getStockAmount(), this.getBatchNo(), this.getAcquisitionCost(), this.getSellingCost());
    }

    @Override
    public String toString() {
        return "Stock{" +
                "product=" + product +
                ", stockAmount=" + stockAmount +
                ", batchNo='" + batchNo + '\'' +
                ", acquisitionCost=" + acquisitionCost +
                ", sellingCost=" + sellingCost +
                '}';
    }
}
