package net.safedata.spring.intro;

import net.safedata.spring.intro.dao.UserDAO;
import net.safedata.spring.intro.entities.User;
import net.safedata.spring.intro.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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

        when(userService.get(anyString())).thenReturn(user);

        assertNotNull(user);
    }
}
