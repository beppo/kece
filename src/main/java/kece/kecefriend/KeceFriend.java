package kece.kecefriend;

import kece.dao.Transactional;
import kece.dao.UserDAO;
import kece.domain.SocialSite;
import kece.domain.User;
import kece.oose.ControlObject;

@ControlObject
public class KeceFriend {
    private final UserDAO userDAO;

    public KeceFriend(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public void keceFriend(User user, User friend, SocialSite socialSite) {
        if (user.isKece()) {
            throw new UserIsKeceException();
        }
        if (friend.isKece()) {
            throw new FriendIsKeceException();
        }
        if (friend.setKece(true)) {
            userDAO.save(friend);
            socialSite.userKeceed(friend, user);
        }
    }
}
