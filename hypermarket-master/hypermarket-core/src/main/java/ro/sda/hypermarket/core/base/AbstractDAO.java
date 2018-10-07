package ro.sda.hypermarket.core.base;

import org.hibernate.Session;

public interface AbstractDAO {
    public Session getCurrentSession();
}
