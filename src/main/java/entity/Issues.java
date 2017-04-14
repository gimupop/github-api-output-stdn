package entity;

//@JsonIgnoreProperties(ignoreUnknown=true)
public class Issues {
    public static String url;
    public static String repository_url;
    public static String labels_url;
    public static String comments_url;
    public static String events_url;
    public static String html_url;
    public static String id;
    public static String number;
    public static String title;
    public static String user;
    public static String labels;
    public static String state;
    public static String locked;
    public static String assignee;
    public static String assignees;
    public static String milestone;
    public static String comments;
    public static String created_at;
    public static String updated_at;
    public static String body;

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        Issues.title = title;
    }

    public static String getBody() {
        return body;
    }

    public static void setBody(String body) {
        Issues.body = body;
    }

}
