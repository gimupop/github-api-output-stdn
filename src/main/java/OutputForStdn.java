import entity.Issues;

import java.util.List;

/**
 * Created by yanagawa_keita on 2017/04/14.
 */
public class OutputForStdn implements Output{

/*    List<Issues> target;
    OutputForStdn(List<Issues> target){
        this.target = target;
    }*/

    @Override
    public void outputTitleAndBodyFromIssues(List<Issues> target){
        target.forEach(issue -> {
            String title;
            String body;
            if(issue.getTitle().length() < 10){
                title = issue.getTitle();
            }else{
                title = issue.getTitle().substring(0,9);
            }
            if(issue.getBody().length() < 30){
                body = issue.getBody();
            }else{
                body = issue.getBody().substring(0,29);
            }

            System.out.print(title + "\t:" + body + "\n");
        });

    }
}
