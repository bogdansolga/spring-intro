package net.safedata.spring.intro.transport;

import java.io.Serializable;

public class ProductTO implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
