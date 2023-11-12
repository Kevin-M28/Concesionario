package Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity(name = "Client")
@Table(name = "clients")
public class Client extends User {
    private String telephone;

    @OneToMany(mappedBy = "client")
    private List<Sale> sales_hisory;
    public Client() {
        super();
        this.telephone = "";
    }

    public Client(String username, String password, String e_mail, Role role, String telephone) {
        super(username, password, e_mail, role);
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public List<Sale> getSales_hisory() {
        return sales_hisory;
    }

    public void setSales_hisory(List<Sale> sales_hisory) {
        this.sales_hisory = sales_hisory;
    }

}
