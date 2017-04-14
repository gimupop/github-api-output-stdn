import java.util.List;
import java.util.Optional;

import entity.Issues;

public class Main {

    public static void main(String[] args) {

        InputFromApi inputFromApi = new InputFromApi();
        Optional<List<Issues>> optIssues = Optional.ofNullable(inputFromApi.getIssues());
        optIssues.ifPresent(issues ->{
            OutputForStdn outputForStdn = new OutputForStdn();
            outputForStdn.outputTitleAndBodyFromIssues(issues);
            //file output
            //OutputForFile outputForFile = new OutputForFile();
            //outputForFile.outputTitleAndBodyFromIssues(issues);
        });

    }


}
