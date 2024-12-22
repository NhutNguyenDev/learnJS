package service;

import model.actor;

public class actorService {
        public actor convertToActor(String dataActor) {

        int indexOf_Id = dataActor.indexOf("\"id\"");
        int indexOf_Login = dataActor.indexOf("\"login\"");
        int indexOf_Display_login = dataActor.indexOf("\"display_login\"");
        int indexOf_Gravatar_id = dataActor.indexOf("\"gravatar_id\"");
        int indexOf_url = dataActor.indexOf("\"url\"");
        int indexOf_avatar_url = dataActor.indexOf("\"avatar_url\"");

        String id = dataActor.substring(indexOf_Id + 5, indexOf_Login - 1);
        String login = dataActor.substring(indexOf_Login + 9, indexOf_Display_login - 2);
        String display_login = dataActor.substring(indexOf_Display_login + 17, indexOf_Gravatar_id - 2);
        String gravatar_id = dataActor.substring(indexOf_Gravatar_id + 14, indexOf_url - 1);
        String url = dataActor.substring(indexOf_url + 7, indexOf_avatar_url - 2);

        int indexOf_End_AvatarUrl = dataActor.indexOf("}", indexOf_avatar_url);
        String avatar_url = dataActor.substring(indexOf_avatar_url + 14, indexOf_End_AvatarUrl - 1);

        return new actor(id, login, display_login, gravatar_id, url, avatar_url);

    }
}
