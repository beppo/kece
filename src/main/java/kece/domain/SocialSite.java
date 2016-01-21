package kece.domain;

import kece.oose.EntityObject;

@EntityObject
public interface SocialSite {
    /**
     * Notifies user by means available that he/she has been keceed by a friend. All shared friend should see this notification.
     *
     * @param user user that is made kece
     * @param by   user that made kece
     */
    void userMadeKece(User user, User by);

    /**
     * Notifies by means available that user kece is undone. This notification should be visible to all shared friends.
     *
     * @param user user who was kece previously
     * @param by     user who removed friends kece
     */
    void usersKeceUndone(User user, User by);
}
