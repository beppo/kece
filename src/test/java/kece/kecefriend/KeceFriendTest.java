package kece.kecefriend;

import kece.dao.UserDAO;
import kece.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class KeceFriendTest {

    @Mock private UserDAO userDAO;
    @Mock private SocialSite socialSite;
    KeceFriend keceFriend;
    private User user;
    private User friend;

    @Before
    public void setUp() {
        keceFriend = new KeceFriend(userDAO);
        user = new User();
        friend = new User();
        user.addFriends(socialSite, Arrays.asList(friend));
        friend.addFriends(socialSite, Arrays.asList(user));
    }

    @Test(expected = UserIsKeceException.class)
    public void keceUserCanNotKeceOtherUsers() {
        user.setKece(true);
        keceFriend.keceFriend(user, friend, socialSite);
    }

    @Test(expected = FriendIsKeceException.class)
    public void keceFriendsCanNotBeKeceedAgain() {
        friend.setKece(true);
        keceFriend.keceFriend(user, friend, socialSite);

    }

    @Test
    public void friendIsKece(){
        keceFriend.keceFriend(user,friend,socialSite);
        assertTrue(friend.isKece());
    }
}