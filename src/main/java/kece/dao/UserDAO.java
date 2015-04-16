package kece.dao;

import kece.domain.SocialSite;
import kece.domain.User;

public interface UserDAO {
    /**
     * Persist user.
     *
     * @param user
     */
    void save(User user);

    /**
     * Find and returns user. A user can have multiple social site accounts and same user should be accessible through any of the accounts.
     *
     * @param socialSite the site
     * @param userId     id with which user is identified on the site
     * @return the user
     */
    User findUser(SocialSite socialSite, String userId);
}
