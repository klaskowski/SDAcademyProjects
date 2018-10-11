package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.ClientDAO;
import ro.sda.hypermarket.core.entity.Client;
import ro.sda.hypermarket.core.repository.ClientRepository;

import java.util.List;

@Service("clientService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client create(Client client, boolean useHibernate) {
        if(useHibernate) {
            return clientDAO.create(client);
        }
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client, boolean useHibernate) {
        if(useHibernate) {
            return clientDAO.update(client);
        }
        return clientRepository.save(client);
    }

    @Override
    public Client getClient(long id, boolean useHibernate) {
        if(useHibernate) {
            return clientDAO.getClient(id);
        }
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> findAll(boolean useHibernate) {
        if(useHibernate) {
            return clientDAO.findAll();
        }
        return clientRepository.findAll();
    }

    @Override
    public void delete(Client client, boolean useHibernate) {
        if(useHibernate) {
            clientDAO.delete(client);
        } else {
            clientRepository.delete(client);
        }
    }
}
