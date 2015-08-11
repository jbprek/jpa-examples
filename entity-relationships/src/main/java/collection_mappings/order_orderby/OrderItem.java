package collection_mappings.order_orderby;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

/**
 * @author prekezes.
 */
@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private long id;

    @OrderColumn
    private String name;

    @ManyToOne
    private CustOrder order;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustOrder getOrder() {
        return order;
    }

    public void setOrder(CustOrder department) {
        this.order = department;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", order=" + order.getName() +
                '}';
    }
}



