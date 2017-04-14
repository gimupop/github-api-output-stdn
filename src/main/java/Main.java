import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class Main {

    public static class MyPOJO {
        public String title;
        public String body;
    }

    public static void main(String[] args) {
        //Client client = ClientBuilder.newClient();
        //WebTarget target = client.target("https://api.github.com")
        //        .path("/repos/spring-projects/spring-boot/issues");

        String hoge = "[{\"title\":\"Harry Potter and the Philosopher's Stone\",\"body\":\"J.K. Rowling\"},{\"title\":\"Harry Potter and the Philosopher's Stone\",\"body\":\"J.K. Rowling\"}]";

        try {
            //String result = target.request().get(String.class);
            //System.out.println(result);
            ObjectMapper mapper = new ObjectMapper();
            try {
                //Issues issues = mapper.readValue(result, Issues.class);
                //List<Issues> issues = mapper.readValue(result, new TypeReference<List<Issues>>() {});
                List<Issues> issues = mapper.readValue(hoge, new TypeReference<List<Issues>>() {});
                //List<MyPOJO> issues = mapper.readValue(hoge, new TypeReference<List<MyPOJO>>() {});

                System.out.println(issues.size());
                //System.out.println(issues.get(1).getTitle());
                //System.out.println(issues.get(1).getBody());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (BadRequestException e) {
            //logger.error("response=" + e.getResponse().readEntity(String.class), e);
            throw e;
        }

    }


}
