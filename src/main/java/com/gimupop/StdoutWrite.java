package com.gimupop;

import com.gimupop.entity.Issue;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class StdoutWrite extends AbstractWrite {

    @Override
    public void printTitleAndBodyFromIssues(List<Issue> target, int titleLength, int bodyLength) {
        target.forEach(issue ->
            System.out.print(escapeTabAndLinefeed(StringUtils.left(issue.getTitle(), titleLength)) +
                    "\t" + escapeTabAndLinefeed(StringUtils.left(issue.getBody(), bodyLength)) + "\n")
        );
    }

}

