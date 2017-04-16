package com.gimupop;

import java.util.List;
import java.util.Optional;

import com.gimupop.entity.Issue;
import org.apache.commons.lang3.StringUtils;

public class Main {

    private static final String DEFAULT_READ = "api";
    private static final String DEFAULT_WRITE = "stdout";
    private static final int DEFAULT_PER_PAGE = 30;

    public static void main(String[] args) {

        String read = DEFAULT_READ;
        String write = DEFAULT_WRITE;
        int parPage = DEFAULT_PER_PAGE;

        if (args != null && args.length > 0 && StringUtils.isNotEmpty(StringUtils.trim(args[0]))) {
            read = args[0];
        }
        if (args != null && args.length > 1 && StringUtils.isNotEmpty(StringUtils.trim(args[1]))) {
            write = args[1];
        }
        if (args != null && args.length > 2 && StringUtils.isNotEmpty(StringUtils.trim(args[2]))) {
            try {
                parPage = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                throw new RuntimeException("取得件数は数字で指定してください。 値: " + args[2], e);
            }
        }

        Optional<List<Issue>> optIssues = read(read,parPage);
        write(optIssues, write);

    }

    private static Optional<List<Issue>>  read(String read,int parPage){
        Optional<List<Issue>> optIssues;
        if (read.equals("api")) {
            Read readFromApi = new ApiRead();
            optIssues = Optional.ofNullable(readFromApi.getIssues(parPage));
        } else {
            throw new RuntimeException("inputの指定が間違っています。 値: " + read);
        }

        return optIssues;
    }

    private static void write(Optional<List<Issue>> optIssues,  String write){
        String finalWrite = write;
        optIssues.ifPresent(issues -> {
            switch (finalWrite) {
                case "stdout":
                    Write stdoutWrite = new StdoutWrite();
                    stdoutWrite.printTitleAndBodyFromIssues(issues, 10, 30);
                    break;
                case "file":
                    Write outputForFile = new FileWrite();
                    outputForFile.printTitleAndBodyFromIssues(issues, 10, 30);
                    break;
                default:
                    throw new RuntimeException("utputの指定が間違っています。 値: " + finalWrite);
            }
        });

    }


}
