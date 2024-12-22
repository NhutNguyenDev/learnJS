package service.payloadService;

import model.payload;
import model.commits;

import service.payloadService.commits.commitsService;

public class payloadService {

    commitsService commitsService = new commitsService();

    public payload convertToPayload(String dataPayload) {

        int indexOf_repository_id = dataPayload.indexOf("\"repository_id\"");

        // indexOf_repository_id = -1 mean don't have Id of repo, convert different
        if (indexOf_repository_id != -1) {
            return convertPayloadWithRepoHaveId(dataPayload, indexOf_repository_id);
        } else {
            return convertPayloadNoId(dataPayload);
        }

    }

    private payload convertPayloadWithRepoHaveId(String dataPayload, int indexOf_repository_id) {

        int indexOf_push_id = dataPayload.indexOf("\"push_id\"");
        int indexOf_size = dataPayload.indexOf("\"size\"");
        int indexOf_distinct_size = dataPayload.indexOf("\"distinct_size\"");
        int indexOf_ref = dataPayload.indexOf("\"ref\"");
        int indexOf_head = dataPayload.indexOf("\"head\"");
        int indexOf_before = dataPayload.indexOf("\"before\"");
        int indexOf_commits = dataPayload.indexOf("\"commits\"");

        String repository_id = dataPayload.substring(indexOf_repository_id + 15, indexOf_push_id - 1);
        String push_id = dataPayload.substring(indexOf_push_id + 11, indexOf_size - 1);
        String size = dataPayload.substring(indexOf_size + 8, indexOf_distinct_size - 1);
        String distinct_size = dataPayload.substring(indexOf_distinct_size + 17, indexOf_ref - 1);
        String ref = dataPayload.substring(indexOf_ref + 7, indexOf_head - 2);
        String head = dataPayload.substring(indexOf_head + 8, indexOf_before - 2);
        String before = dataPayload.substring(indexOf_before + 10, indexOf_commits - 2);

        // Get String of Commits Obj
        String commits = dataPayload.substring(indexOf_commits + 10, dataPayload.length() - 1);
        // Convert to Commits Obj
        commits newCommits = commitsService.convertToCommits(commits);

        return new payload(repository_id, push_id, size, distinct_size, ref, head, before, newCommits, true);
    }

    private payload convertPayloadNoId(String dataPayload) {

        int indexOf_ref = dataPayload.indexOf("\"ref\"");
        int indexOf_ref_type = dataPayload.indexOf("\"ref_type\"");
        int indexOf_master_branch = dataPayload.indexOf("\"master_branch\"");
        int indexOf_description = dataPayload.indexOf("\"description\"");
        int indexOf_pusher_type = dataPayload.indexOf("\"pusher_type\"");

        String ref = dataPayload.substring(indexOf_ref + 6, indexOf_ref_type - 1);
        String ref_type = dataPayload.substring(indexOf_ref_type + 12, indexOf_master_branch - 2);
        String master_branch = dataPayload.substring(indexOf_master_branch + 17, indexOf_description - 2);
        String description = dataPayload.substring(indexOf_description + 15, indexOf_pusher_type - 2);
        String pusher_type = dataPayload.substring(indexOf_pusher_type + 15, dataPayload.length() - 2);

        return new payload(ref, ref_type, master_branch, description, pusher_type);

    }
}
