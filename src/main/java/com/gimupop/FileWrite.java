package com.gimupop;

import com.gimupop.entity.Issue;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWrite extends AbstractWrite {

    @Override
    public void printTitleAndBodyFromIssues(List<Issue> target, int titleLength, int bodyLength) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.tsv"))) {
            target.forEach(issue -> {
                try {
                    bw.write(escapeTabAndLinefeed(StringUtils.left(issue.getTitle(), titleLength)) +
                            "\t" + escapeTabAndLinefeed(StringUtils.left(issue.getBody(), bodyLength)) + "\n");
                } catch (IOException e) {
                    throw new RuntimeException("ファイル書き込み時にエラーが発生しました。エラーログをご確認ください。", e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException("ファイル書き込み時にエラーが発生しました。エラーログをご確認ください。", e);
        }

    }

}
