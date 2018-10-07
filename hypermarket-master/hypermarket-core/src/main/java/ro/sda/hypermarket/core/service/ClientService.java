package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Client;

import java.util.List;

public interface ClientService {

    public Client create(Client client);

    public Client update(Client client);

    public Client getClient(long id);

    public List<Client> findAll();

    public void delete(Client client);
}
