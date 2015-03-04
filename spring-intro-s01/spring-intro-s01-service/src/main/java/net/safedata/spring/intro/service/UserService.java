package net.safedata.spring.intro.service;

import net.safedata.spring.intro.entities.User;

/**
 * Interface used to define the {@link net.safedata.spring.intro.entities.User} related services
 *
 * @author bogdan.solga
 *
 * Date: 27.06.2014, time: 09:33
 */
public interface UserService {
    public User getJohnDoe();
}
