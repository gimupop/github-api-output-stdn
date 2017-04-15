package com.gimupop;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gimupop.entity.Issue;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.io.IOException;
import java.util.List;

/**
 * Created by yanagawa_keita on 2017/04/14.
 */
public class ApiRead implements Read {

    @Override
    public List<Issue> getIssues(int perPage) {
        List<Issue> issues = null;
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://api.github.com")
                .path("/repos/spring-projects/spring-boot/issues")
                .queryParam("per_page", perPage);
        try {
            String result = target.request().get(String.class);
            ObjectMapper mapper = new ObjectMapper();
            issues = mapper.readValue(result, new TypeReference<List<Issue>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException("API使用時にエラーが発生しました。エラーログをご確認ください。" , e);
        }

        return issues;
    }
}
