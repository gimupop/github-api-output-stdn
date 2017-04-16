package com.gimupop;

import com.gimupop.entity.Issue;
import mockit.Expectations;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(JMockit.class)
public class ApiReadTest {
    @Mocked
    private WebTarget webTarge;
    @Test
    public void getIssues() throws Exception {
        Read apiRead = new ApiRead();
        List<Issue> result = apiRead.getIssues(10);
        assertEquals(10,result.size());
    }
}