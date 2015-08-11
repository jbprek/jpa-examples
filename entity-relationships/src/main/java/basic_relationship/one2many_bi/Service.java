package basic_relationship.one2many_bi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by john on 8/9/15.
 */
@Entity
public class Service {
    @GeneratedValue
    @Id
    private long id;

    private String name;

    @OneToMany(mappedBy="service")
    private Set<Subscriber> subscribers= new HashSet<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
