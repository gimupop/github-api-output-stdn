import entity.Issues;

import java.util.List;

/**
 * Created by yanagawa_keita on 2017/04/14.
 */
public interface Output {

    public void outputTitleAndBodyFromIssues(List<Issues> target);
}
