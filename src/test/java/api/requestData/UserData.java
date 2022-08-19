package api.requestData;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserData {

    @JsonProperty
    public String username;

    @JsonProperty
    public String password;

    public UserData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserData() {
    }
}
