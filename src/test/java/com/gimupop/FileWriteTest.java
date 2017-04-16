package com.gimupop;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gimupop.entity.Issue;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class FileWriteTest {

    @Before
    public void before() throws Exception {
        FileUtils.forceDelete(new File("output.tsv"));
    }

    @Test
    public void printTitleAndBodyFromIssues() throws Exception {

        Write fileWrite = new FileWrite();
        ObjectMapper mapper = new ObjectMapper();
        List<Issue> issues = mapper.readValue(new File("src/test/resources/testData.json"),
                new TypeReference<List<Issue>>() {
                });

        fileWrite.printTitleAndBodyFromIssues(issues, 10, 30);
        List<String> actual = loadFile("output.tsv");
        List<String> expected = loadFile("src/test/resources/expectOutput.tsv");
        assertEquals(expected, actual);

    }

    public List<String> loadFile(String path) throws Exception {

        try (FileReader fr = new FileReader(path);
             BufferedReader br = new BufferedReader(fr)) {
            return br.lines().collect(Collectors.toList());
        }
    }

}