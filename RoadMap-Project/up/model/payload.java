package model;

public class payload {

    // No id
    private String ref;
    private String ref_type;
    private String master_branch;
    private String description;
    private String pusher_type;

    // HasId
    private String repository_id;
    private String push_id;
    private String size;
    private String distinct_size;
    private String refHasId;
    private String head;
    private String before;
    private commits commits;

    // Check have id (Default is don't have id)
    private boolean hasId = false;

    public payload(String repository_id, String push_id, String size, String distinct_size, String refHasId,
            String head, String before, model.commits commits, boolean hasId) {
        this.repository_id = repository_id;
        this.push_id = push_id;
        this.size = size;
        this.distinct_size = distinct_size;
        this.refHasId = refHasId;
        this.head = head;
        this.before = before;
        this.commits = commits;
        this.hasId = hasId;
    }

    public payload(String ref, String ref_type, String master_branch, String description, String pusher_type) {
        this.ref = ref;
        this.ref_type = ref_type;
        this.master_branch = master_branch;
        this.description = description;
        this.pusher_type = pusher_type;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getRef_type() {
        return ref_type;
    }

    public void setRef_type(String ref_type) {
        this.ref_type = ref_type;
    }

    public String getMaster_branch() {
        return master_branch;
    }

    public void setMaster_branch(String master_branch) {
        this.master_branch = master_branch;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPusher_type() {
        return pusher_type;
    }

    public void setPusher_type(String pusher_type) {
        this.pusher_type = pusher_type;
    }

    public String getRepository_id() {
        return repository_id;
    }

    public void setRepository_id(String repository_id) {
        this.repository_id = repository_id;
    }

    public String getPush_id() {
        return push_id;
    }

    public void setPush_id(String push_id) {
        this.push_id = push_id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDistinct_size() {
        return distinct_size;
    }

    public void setDistinct_size(String distinct_size) {
        this.distinct_size = distinct_size;
    }

    public String getRefHasId() {
        return refHasId;
    }

    public void setRefHasId(String refHasId) {
        this.refHasId = refHasId;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public commits getCommits() {
        return commits;
    }

    public void setCommits(commits commits) {
        this.commits = commits;
    }

    @Override
    public String toString() {
        if (hasId) {
            return "\n\t{\n\trepository_id=" + repository_id + ", \n\tpush_id=" + push_id + ", \n\tsize=" + size
                    + ", \n\tdistinct_size=" + distinct_size + ", \n\trefHasId=" + refHasId + ", \n\thead=" + head + ", \n\tbefore="
                    + before + ", \n\tcommits=" + commits + "\t]";
        }
        return "\n\t{\n\tref=" + ref + ", \n\tref_type=" + ref_type + ", \n\tmaster_branch="
                + master_branch + ", \n\tdescription="
                + description + ", \n\tpusher_type=" + pusher_type + "\n\t}";
    }

}
