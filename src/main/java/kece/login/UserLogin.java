package kece.login;

import kece.dao.UserDAO;
import kece.domain.SocialSite;
import kece.domain.User;

public class UserLogin {
	private final UserDAO userDao;

	public UserLogin(UserDAO userDao) {
		this.userDao = userDao;
	}

	public void userLoggedIn(SocialSite socialSite, String userId) {
		User user = userDao.findUser(socialSite, userId);
		user.setKece(socialSite.isUserKece(user));
	}
}
