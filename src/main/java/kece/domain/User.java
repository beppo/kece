package kece.domain;

import kece.oose.EntityObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

@EntityObject
public class User {
    private final AtomicBoolean kece = new AtomicBoolean();
    private transient Map<SocialSite, List<User>> friends = new ConcurrentHashMap<>();

    public List<User> getFriends(SocialSite site) {
        return friends.get(site);
    }

    public void addFriends(SocialSite site, Collection<User> friends) {
        this.friends.put(site, new ArrayList<>(friends));
    }

    public boolean isKece() {
        return kece.get();
    }

    /**
     * This must ensure that only on user can do make kece.
     *
     * @param value
     */
    public boolean setKece(boolean value) {
        return kece.compareAndSet(!value, value);
    }
}
