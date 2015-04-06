package net.safedata.spring.intro;

import net.safedata.spring.intro.dao.UserDAO;
import net.safedata.spring.intro.entities.User;
import net.safedata.spring.intro.service.UserServiceImpl;
import net.safedata.spring.intro.transport.UserTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceMockitoTest {

    @Mock
    private UserDAO userDAO;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void getUserReturnsANotNullUser() {
        User user = mock(User.class);
        when(user.getUserName()).thenReturn("ana");

        when(userDAO.get(anyString())).thenReturn(user);

        User anotherUser = userService.get("ceva");

        assertNotNull(anotherUser);
        assertEquals(anotherUser.getUserName(), "ana");
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenEmpty() {
        when(userDAO.get(-1)).thenThrow(new IllegalArgumentException("cannot return a negative userId"));

        userService.get(-1);
    }
}
