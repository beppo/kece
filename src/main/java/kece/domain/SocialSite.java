package kece.domain;

import kece.oose.EntityObject;

@EntityObject
public interface SocialSite {
    /**
     * Notifies user by available means that he/she has been keceed by a friend.
     *
     * @param user     user that is made kece
     * @param by user that made kece
     */
    void userMadeKece(User user, User by);
}
