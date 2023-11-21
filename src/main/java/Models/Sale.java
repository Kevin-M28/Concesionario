package Models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;


@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    private String date;
    private double total;
    private String payment_method;

    public Sale() {
        this.client = new Client();
        this.vehicle = new Vehicle();
        this.date = "";
        this.total = 0;
        this.payment_method = "";
    }
    public Sale(Client client, Vehicle vehicle, String date, double total, String payment_method) {
        this.client = client;
        this.vehicle = vehicle;
        this.date = date;
        this.total = total;
        this.payment_method = payment_method;
    }
    public int getId() {
        return id;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }

    public String getPayment_method() {
        return payment_method;
    }
    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", client=" + client +
                ", vehicle=" + vehicle +
                ", date='" + date + '\'' +
                ", total=" + total +
                ", payment_method='" + payment_method + '\'' +
                '}';
    }


}
