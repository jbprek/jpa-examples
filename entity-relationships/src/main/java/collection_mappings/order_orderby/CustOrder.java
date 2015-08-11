package collection_mappings.order_orderby;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.*;

/**
 * @author prekezes.
 */
@Entity
public class CustOrder {

    @Id @GeneratedValue
    private long id;

    private String name;

    /*
     * This is a joke you have to maintain manually order while inserting updating or deleting from the items list
     */
    @OneToMany(mappedBy = "order")
    @OrderBy("name DESC") //   alternative ("name DESC")
    private List<OrderItem> items;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
