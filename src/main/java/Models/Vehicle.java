package Models;

import jakarta.persistence.*;

@Entity(name = "Vehicle")
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50)
    private String model;
    @Column(length = 50)
    private String fabricant;
    @Column(length = 50)
    private String year;
    @Column(length = 50)
    private String color;
    @Column(length = 30)
    private Double price;
    @Column(length = 30)
    private int stock;

    public Vehicle() {
        String model = "";
        String fabricant = "";
        String year = "";
        String color = "";
        Double price = 0.0;
        int stock = 0;
    }

    public Vehicle(String model, String fabricant, String year, String color, Double price, int stock) {
        this.model = model;
        this.fabricant = fabricant;
        this.year = year;
        this.color = color;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFabricant() {
        return fabricant;
    }

    public void setFabricant(String fabricant) {
        this.fabricant = fabricant;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", fabricant='" + fabricant + '\'' +
                ", year='" + year + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}