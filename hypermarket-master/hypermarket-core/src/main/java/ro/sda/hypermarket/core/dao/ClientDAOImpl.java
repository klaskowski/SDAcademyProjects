package ro.sda.hypermarket.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.Client;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
@Transactional
public class ClientDAOImpl implements ClientDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Client create(Client client) {
        getCurrentSession().save(client);
        return client;
    }

    @Override
    public Client update(Client client) {
        Transaction tr = getCurrentSession().beginTransaction();
        getCurrentSession().update(client);
        getCurrentSession().flush();
        tr.commit();
        return client;
    }

    @Override
    public Client getClient(long id) {
        Client searchedClient = getCurrentSession().get(Client.class, id);
        return searchedClient;
    }

    @Override
    public List<Client> findAll() {
        CriteriaQuery<Client> criteriaQuery = getCurrentSession().getCriteriaBuilder().createQuery(Client.class);
        criteriaQuery.from(Client.class);
        List<Client> clientList = getCurrentSession().createQuery(criteriaQuery).getResultList();
        return clientList;
    }

    @Override
    public void delete(Client client) {
        Transaction tr = getCurrentSession().beginTransaction();
        Client found = (Client) getCurrentSession().get(Client.class, client.getId());
        getCurrentSession().delete(found);
        getCurrentSession().flush();
        tr.commit();
    }

}
