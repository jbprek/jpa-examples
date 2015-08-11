package basic_relationship.many2many_bi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class BankCustomer {

    @GeneratedValue
    @Id
    private long id;

    private String name;
    /* Owner */
    @ManyToMany
//    @JoinTable( joinColumns = {name="CUST_ACCT", joinColumns={@JoinColumn(name="CUST_ID")}, inverseJoinColumns = {@JoinColumn(name="ACCT_ID")})
    private Set<BankAccount> accounts = new HashSet<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<BankAccount> accounts) {
        this.accounts = accounts;
    }
}
