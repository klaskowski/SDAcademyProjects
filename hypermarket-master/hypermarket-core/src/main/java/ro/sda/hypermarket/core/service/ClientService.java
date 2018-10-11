package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Client;

import java.util.List;

public interface ClientService {

    public Client create(Client client, boolean useHibernate);

    public Client update(Client client, boolean useHibernate);

    public Client getClient(long id, boolean useHibernate);

    public List<Client> findAll(boolean useHibernate);

    public void delete(Client client, boolean useHibernate);
}
