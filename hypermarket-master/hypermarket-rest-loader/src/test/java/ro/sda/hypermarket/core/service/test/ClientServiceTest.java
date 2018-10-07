package ro.sda.hypermarket.core.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.sda.hypermarket.core.entity.Client;
import ro.sda.hypermarket.core.service.ClientService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    @Test
    public void testCreate(){
        Client client = new Client();
        client.setName("Test Client2");
        client.setType("test type");

        clientService.create(client);
        System.out.println(client.toString());
        assertNotNull(client);
        clientService.delete(client);
    }

    @Test
    public void testUpdate(){
        Client client = new Client();
        client.setName("Test Client3");
        client.setType("test type");
        clientService.create(client);
        client.setName("Updated Client Name");
        clientService.update(client);

        System.out.println(client.toString());
        clientService.delete(client);
    }

    @Test
    public void testGetClient(){
        Client client = new Client();
        client.setName("Test Client3");
        client.setType("test type");

        clientService.create(client);

        assertNotNull(clientService.getClient(client.getId()));
        System.out.println(client.toString());
        clientService.delete(client);
    }

    @Test
    public void testFindAll(){
        Client client = new Client();
        client.setName("Test Client50");
        client.setType("test type");

        client = clientService.create(client);

        Client client1 = new Client();
        client1.setName("Test Client58");
        client1.setType("test type2");

        client1 = clientService.create(client1);

        List<Client> clientList = new ArrayList<>();
        clientList = clientService.findAll();
        assertNotNull(clientList);
        clientList.forEach(System.out::println);
        clientService.delete(client);
        clientService.delete(client1);
    }

    @Test
    public void testDelete(){
        Client client = new Client();
        client.setName("Client 4 Deletion");
        client.setType("Type for Deletion");
        clientService.create(client);

        clientService.delete(client);

        assertNull(clientService.getClient(client.getId()));
    }
}
