import entity.Issues;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by yanagawa_keita on 2017/04/14.
 */
public class OutputForFile implements Output {

    @Override
    public void outputTitleAndBodyFromIssues(List<Issues> target) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("hoge.text"));
            target.forEach(issue -> {
                String title;
                String body;
                if (issue.getTitle().length() < 10) {
                    title = issue.getTitle();
                } else {
                    title = issue.getTitle().substring(0, 9);
                }
                if (issue.getBody().length() < 30) {
                    body = issue.getBody();
                } else {
                    body = issue.getBody().substring(0, 29);
                }

                try {
                    bw.write(title + "\t" + body + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
