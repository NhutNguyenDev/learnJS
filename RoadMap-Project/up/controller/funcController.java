package controller;
import java.time.ZonedDateTime;

import model.actor;
import model.commits;
import model.payload;
import model.repo;
import service.actorService;
import service.repoService;
import service.payloadService.payloadService;

public class funcController {

    actorService actorService = new actorService();
    repoService repoService = new repoService();
    payloadService payloadService = new payloadService();


    public actor convertToActor(String dataActor) {
        return actorService.convertToActor(dataActor);
    }

    public repo convertToRepo(String dataRepo) {
        return repoService.convertToRepo(dataRepo);
    }

    public payload convertToPayload(String dataPayload) {
        return payloadService.convertToPayload(dataPayload);
    }

    
    public commits convertToCommits(String dataCommits) {
        return null;
    }

    public void printList() {
    }

    public ZonedDateTime convertToZonedDateTime(String data) {
        return null;
    }
}
