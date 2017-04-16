package com.gimupop;

import com.gimupop.entity.Issue;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AbstractWriteTest {
    @Test
    public void normal() throws Exception {
        AbstractWrite abstractWrite = new AbstractWrite() {
            @Override
            public void printTitleAndBodyFromIssues(List<Issue> target, int titleLength, int bodyLength) {
            }
        };
        String expected = "hoge\\\\nhuga\\\\thugahuga";
        String result = abstractWrite.escapeTabAndLinefeed("hoge\r\nhuga\thugahuga");

        assertEquals(expected,result);
    }
}

