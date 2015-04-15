package kece.kecefriend;

import kece.domain.SocialSite;
import kece.domain.User;

public class KeceFriend {

    public void keceFriend(User user, User friend, SocialSite socialSite) {
        if (user.keceFriend(friend)) {
            socialSite.userKeceed(friend, user);
        }
    }
}
