package clienterestful;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author User
 */
public class Cliente {

    private final WebTarget webTarget;
    private final Client client;
    private static final String BASE_URI = "http://localhost:8080/TCI-war/meuservico";
    //http://localhost:8080/TCI-war/meuservico/testeservico

    public Cliente() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("testeservico");
    }

    public String testeGetText() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public User validaLogin(String usuario, String senha) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{usuario}));
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{senha}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(User.class);
    }
}
