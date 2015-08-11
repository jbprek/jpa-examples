package collection_mappings.order_persisted;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import java.util.ArrayList;
import java.util.List;

/**
 * @author prekezes.
 */
@Entity
public class PrintQueue {

    @Id @GeneratedValue
    private long id;

    private String name;

    /*
     * This is a joke you have to maintain manually order while inserting updating or deleting from the items list
     */
    @OneToMany(mappedBy = "queue")
    @OrderColumn(name = "PRINT_ITEM") //
    private List<PrintItem> items = new ArrayList<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PrintItem> getItems() {
        return items;
    }

    public void setItems(List<PrintItem> items) {
        this.items = items;
    }
}
