import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Issues;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanagawa_keita on 2017/04/14.
 */
public class InputFromApi implements Input{

    @Override
    public List<Issues> getIssues() {
        List<Issues> issues= null;
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://api.github.com")
                .path("/repos/spring-projects/spring-boot/issues");
        try {
            String result = target.request().get(String.class);
            ObjectMapper mapper = new ObjectMapper();
            issues = mapper.readValue(result, new TypeReference<List<Issues>>() {});
        }catch (IOException e) {
        e.printStackTrace();
    }

        return issues;
    }
}
