package kece;

import com.google.common.eventbus.EventBus;
import kece.domain.SocialSite;
import kece.domain.User;
import kece.domain.events.UsersKeceUndone;
import org.aspectj.lang.annotation.Aspect;

/**
 * Captures business events and fires them on the event bus.
 */
@Aspect
public class KeceEventCaptureAspect {
    private EventBus eventBus;

    /**
     * Whenever a user is successfully made kece this method should capture it as an event and fire.
     *
     * @param user       user who has been made kece
     * @param friend     user who made kece
     * @param socialSite the social site {@code doer} was on
     */
    public void captureUserMadeKece(User user, User friend, SocialSite socialSite) {
        eventBus.post(new UsersKeceUndone(user, friend, socialSite));
    }

    /**
     * Whenever a users kece is undone successfully this method should capture it as an event and fire.
     *
     * @param user       user who was kece previously
     * @param friend     user who undid kece
     * @param socialSite the social site {@code friend} was on
     */
    public void captureUserKeceUndone(User user, User friend, SocialSite socialSite) {
        eventBus.post(new UsersKeceUndone(user, friend, socialSite));
    }
}
