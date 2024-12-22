
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import controller.funcController;
import model.activity;
import model.actor;
import model.payload;
import model.repo;

public class main {

    static ArrayList<activity> activityList = new ArrayList<>();

    public static void main(String[] args) {
        System.out
                .println("This program will show the recent activity of a GitHub user and display it in the terminal.");

        Scanner sc = new Scanner(System.in);
        System.out.println("Give github username ?");
        String userNameGithub = sc.nextLine();
        String urlFetchData = "https://api.github.com/users/" + userNameGithub
        +"/events";

        // String urlFetchData = "https://api.github.com/users/nhutnguyendev/events";

        System.out.println(urlFetchData);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlFetchData))
                .header("User-Agent", "Java-GitHub-Activity-App")
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                renderJsonToObject(response.body());
            } else {
                System.out.println("Error: " + response.statusCode() + " - " + response.body());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        printList();

        
    }

    // Idea is read each pharase like (id, type, actor, repo, payload, public }
    // and then with each section, read...
    private static void renderJsonToObject(String data) {

        funcController controllerFunc = new funcController();
        // Count index and update index based on the last index of previous activity
        int indexCount = 0;
        while (indexCount != -1) {

            // Find each index from begin of activity ( index begin is "indexCount")
            int indexOfId = data.indexOf("\"id\"", indexCount);
            int indexOfType = data.indexOf("\"type\"", indexCount);
            int indexOfActor = data.indexOf("\"actor\"", indexCount);
            int indexOfRepo = data.indexOf("\"repo\"", indexCount);
            int indexOfPayload = data.indexOf("\"payload\"", indexCount);
            int indexOfPublic = data.indexOf("\"public\"", indexCount);
            int indexOfCreateAt = data.indexOf("\"created_at\"", indexCount);
            int indexOfEndBracket = data.indexOf("},{", indexOfCreateAt);

            // Update the last index of activity for "indexCount"
            // equal to "-1" mean this is the last activity
            indexCount = indexOfEndBracket;

            // Because "indexOfid" is character "_" in `_"id"`
            // Count from 0 -> 6, `"id": "` -> plus 6 character to catch exacly value of id.
            // Similar for all remaining section

            String id = data.substring(indexOfId + 6, indexOfType - 2);
            String type = data.substring(indexOfType + 8, indexOfActor - 2);
            String Ispublic = data.substring(indexOfPublic + 9, indexOfCreateAt - 1);

            String actor = data.substring(indexOfActor + 8, indexOfRepo - 1);
            actor newActor = controllerFunc.convertToActor(actor);

            String repo = data.substring(indexOfRepo + 7, indexOfPayload - 1);
            repo newRepo = controllerFunc.convertToRepo(repo);

            String payload = data.substring(indexOfPayload + 10, indexOfPublic - 1);
            payload newPayload = controllerFunc.convertToPayload(payload);

            ZonedDateTime createAtFormat = null;
            if (indexOfEndBracket != -1) {

                String createAt = data.substring(indexOfCreateAt + 14, indexOfEndBracket - 1);
                createAtFormat = convertToZonedDateTime(createAt);

            } else {
                // Handle the last Activity with index of end is "}]"
                indexOfEndBracket = data.indexOf("}]", indexOfCreateAt);
                String createAt = data.substring(indexOfCreateAt + 14, indexOfEndBracket - 1);
                createAtFormat = convertToZonedDateTime(createAt);
            }

            // Finally, create Activity
            activity newActivity = new activity(id, type, newActor, newRepo, newPayload, Boolean.parseBoolean(Ispublic),
                    createAtFormat);

            activityList.add(newActivity);

        }
    }

    private static void printList() {
        for (activity activity : activityList) {
            System.out.println(activity.toString());
        }
    }

    private static ZonedDateTime convertToZonedDateTime(String data) {
        return ZonedDateTime.parse(data);
    }

}
