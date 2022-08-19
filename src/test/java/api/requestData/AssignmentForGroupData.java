package api.requestData;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssignmentForGroupData {

    @JsonProperty
    public String target_type;

    @JsonProperty
    public String group_id;

    @JsonProperty
    public String content_id;

    public AssignmentForGroupData(String target_type, String group_id, String content_id) {
        this.target_type = target_type;
        this.group_id = group_id;
        this.content_id = content_id;
    }

    public AssignmentForGroupData() {
    }
}
