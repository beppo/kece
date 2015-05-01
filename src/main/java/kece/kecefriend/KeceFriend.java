package kece.kecefriend;

import kece.dao.UserDAO;
import kece.domain.*;
import kece.oose.ControlObject;

@ControlObject
public class KeceFriend {
    private final UserDAO userDAO;

    public KeceFriend(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void keceFriend(User user, User friend, SocialSite socialSite) {
        if (keceFriend(user, friend)) {
            userDAO.save(friend);
            socialSite.userKeceed(friend, user);
        }
    }

    //@Transactional
    private boolean keceFriend(User user, User friend) {
        if (user.isKece()) {
            throw new UserIsKeceException();
        }
        if (!user.allowKece()) {
            user.setAllowKece(true);
        }
        if (friend.isKece()) {
            throw new FriendIsKeceException();
        }
        if (!friend.allowKece()) {
            throw new FriendDoesNotAllowKeceException();
        }
        return friend.setKece(true);
    }
}
