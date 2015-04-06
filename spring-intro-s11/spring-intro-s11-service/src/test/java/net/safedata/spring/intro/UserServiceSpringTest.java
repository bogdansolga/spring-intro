package net.safedata.spring.intro;

import net.safedata.spring.intro.service.UserService;
import net.safedata.spring.intro.transport.UserTO;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Ignore("de aia")
public class UserServiceSpringTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUserReturnsNotNull() {
        /*
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setUserName("john");
        user.setPassword("johnny");
        user.setId(10);

        userService.save(user);

        UserTO returned = userService.get(10);
        */

        UserTO returned = userService.get(3);

        assertNotNull(returned);
        assertEquals(returned.getUserName(), "radu");
    }
}
