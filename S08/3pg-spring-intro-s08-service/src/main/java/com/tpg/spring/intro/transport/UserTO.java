package com.tpg.spring.intro.transport;

import java.io.Serializable;
import java.util.List;

public class UserTO implements Serializable {

    private String userName;

    private String firstName;

    private String lastName;

    private List<ProductTO> products;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<ProductTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductTO> products) {
        this.products = products;
    }
}
