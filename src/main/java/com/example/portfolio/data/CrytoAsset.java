package com.example.portfolio.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Objects;

/**
 * @author brahimabouihia
 * @since 2021-04-18
 */
@Entity
@Table(name = "CRYTOASSET")
public class CrytoAsset {

    @Id
    private String symbol;

    private double total;


    @Transient
    private double price;


    public String getSymbol() {
        return symbol;
    }

    public double getTotal() {
        return total;
    }



    public double getPrice() {
        return price;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }


    public void setTotal(double total) {
        this.total = total;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CrytoAsset{" +
                "symbol='" + symbol + '\'' +
                ", total=" + total +
                ", price=" + price +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrytoAsset that = (CrytoAsset) o;
        if (Double.compare(that.total, total) != 0) return false;
        if (Double.compare(that.price, price) != 0) return false;
        return Objects.equals(symbol, that.symbol);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = symbol != null ? symbol.hashCode() : 0;
        temp = Double.doubleToLongBits(total);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
