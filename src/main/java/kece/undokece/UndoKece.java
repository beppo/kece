package kece.undokece;

import kece.UserIsKeceException;
import kece.dao.Transactional;
import kece.dao.UserDAO;
import kece.domain.SocialSite;
import kece.domain.User;

public class UndoKece {
    private final UserDAO userDAO;

    public UndoKece(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public void undoKece(User user, User friend, SocialSite socialSite) throws UserIsKeceException {
        if (user.isKece()) {
            throw new UserIsKeceException();
        }
        if (friend.setKece(false)) {
            socialSite.usersKeceUndone(friend, user);
        }
    }
}
