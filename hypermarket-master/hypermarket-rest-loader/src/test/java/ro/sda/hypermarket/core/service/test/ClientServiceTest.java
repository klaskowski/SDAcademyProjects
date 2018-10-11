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

        clientService.create(client, false);
        System.out.println(client.toString());
        assertNotNull(client);
        clientService.delete(client, false);
    }

    @Test
    public void testUpdate(){
        Client client = new Client();
        client.setName("Test Client3");
        client.setType("test type");
        clientService.create(client, false);
        client.setName("Updated Client Name");
        clientService.update(client, false);

        System.out.println(client.toString());
        clientService.delete(client, false);
    }

    @Test
    public void testGetClient(){
        Client client = new Client();
        client.setName("Test Client3");
        client.setType("test type");

        clientService.create(client, false);

        assertNotNull(clientService.getClient(client.getId(), false));
        System.out.println(client.toString());
        clientService.delete(client, false);
    }

    @Test
    public void testFindAll(){
        Client client = new Client();
        client.setName("Test Client50");
        client.setType("test type");

        client = clientService.create(client, false);

        Client client1 = new Client();
        client1.setName("Test Client58");
        client1.setType("test type2");

        client1 = clientService.create(client1, false);

        List<Client> clientList = new ArrayList<>();
        clientList = clientService.findAll(false);
        assertNotNull(clientList);
        clientList.forEach(System.out::println);
        clientService.delete(client, false);
        clientService.delete(client1, false);
    }

    @Test
    public void testDelete(){
        Client client = new Client();
        client.setName("Client 4 Deletion");
        client.setType("Type for Deletion");
        clientService.create(client, false);

        clientService.delete(client, false);

        assertNull(clientService.getClient(client.getId(), false));
    }
}
