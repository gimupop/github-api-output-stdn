package com.gimupop;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gimupop.entity.Issue;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.*;

public class StdoutWriteTest {
    @Test
    public void printTitleAndBodyFromIssues() throws Exception {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Write stdoutWrite = new StdoutWrite();
        ObjectMapper mapper = new ObjectMapper();
        List<Issue> issues = mapper.readValue(new File("src/test/resources/testData.json"),
                new TypeReference<List<Issue>>() {
                });

        stdoutWrite.printTitleAndBodyFromIssues(issues, 10, 30);

        assertEquals(out.toString(),(
                "Spring Boo\t<!--\\\\nThanks for raising a Spr\n" +
                "found appl\tIn `YamlPropertySourceLoader`:\n" +
                "Applicatio\tUsing `ApplicationListener<App" + System.lineSeparator()));

    }

}