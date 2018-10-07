package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.ClientDAO;
import ro.sda.hypermarket.core.entity.Client;

import java.util.List;

@Service("clientService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDAO clientDAO;

    @Override
    public Client create(Client client) {
        return clientDAO.create(client);
    }

    @Override
    public Client update(Client client) {
        return clientDAO.update(client);
    }

    @Override
    public Client getClient(long id) {
        return clientDAO.getClient(id);
    }

    @Override
    public List<Client> findAll() {
        return clientDAO.findAll();
    }

    @Override
    public void delete(Client client) {
        clientDAO.delete(client);
    }
}
