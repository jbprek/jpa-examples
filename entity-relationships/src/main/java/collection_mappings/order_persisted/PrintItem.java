package collection_mappings.order_persisted;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author prekezes.
 */
@Entity
public class PrintItem {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private PrintQueue queue;

    @Lob
    @Basic(fetch= FetchType.LAZY)
    private byte[] payLoad;

    public long getId() {
        return id;
    }

    public PrintQueue getQueue() {
        return queue;
    }

    public void setQueue(PrintQueue queue) {
        this.queue = queue;
    }

    public byte[] getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(byte[] payLoad) {
        this.payLoad = payLoad;
    }
}



