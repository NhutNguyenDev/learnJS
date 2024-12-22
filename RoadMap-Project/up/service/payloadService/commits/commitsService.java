package service.payloadService.commits;

import model.author;
import model.commits;

public class commitsService {
    public commits convertToCommits(String dataCommits) {

        int indexOf_sha = dataCommits.indexOf("\"sha\"");
        int indexOf_author = dataCommits.indexOf("\"author\"");
        int indexOf_message = dataCommits.indexOf("\"message\"");
        int indexOf_distinct = dataCommits.indexOf("\"distinct\"");
        int indexOf_url = dataCommits.indexOf("\"url\"");

        String sha = dataCommits.substring(indexOf_sha + 7, indexOf_author - 2);
        String message = dataCommits.substring(indexOf_message + 11, indexOf_distinct - 2);
        String distinct = dataCommits.substring(indexOf_distinct + 11, indexOf_url - 1);

        String author = dataCommits.substring(indexOf_author + 9, indexOf_message - 1);
        author newAuthor = convertToAuthor(author);
        // find index of "}", this is end point of url
        int indexOf_EndOfURL = dataCommits.indexOf("}", indexOf_url);
        String url = dataCommits.substring(indexOf_url + 7, indexOf_EndOfURL - 1);

        return new commits(sha, newAuthor, message, distinct, url);

    }

    private author convertToAuthor(String dataAuthor) {
        int indexOf_email = dataAuthor.indexOf("\"email\"");
        int indexOf_name = dataAuthor.indexOf("\"name\"");

        String email = dataAuthor.substring(indexOf_email + 6, indexOf_name - 1);
        String name = dataAuthor.substring(indexOf_name + 5, dataAuthor.length());

        return new author(email,name);

    }
}
