package model;

public class commits {
    private String sha;
    private author author;
    private String message;
    private String destinct;
    private String url;
    

    
    public commits(String sha, author author, String message, String destinct, String url) {
        this.sha = sha;
        this.author = author;
        this.message = message;
        this.destinct = destinct;
        this.url = url;
    }

    public String getSha() {
        return sha;
    }
    public void setSha(String sha) {
        this.sha = sha;
    }
    public author getAuthor() {
        return author;
    }
    public void setAuthor(author author) {
        this.author = author;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getDestinct() {
        return destinct;
    }
    public void setDestinct(String destinct) {
        this.destinct = destinct;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "[\n\t\t{\n\t\tsha=" + sha + ", \n\t\tauthor=" + author + ", \n\t\tmessage=" + message + ", \n\t\tdestinct=" + destinct
                + ", \n\t\turl=" + url + "\n\t\t}\n\t";
    }

    
}
