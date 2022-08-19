package api.responseData;

import api.requestData.UserData;

public class UserRegister extends UserData {
    public UserRegister(String username, String password){
        super(username,password);
    }

    public UserRegister() {
    }
}
