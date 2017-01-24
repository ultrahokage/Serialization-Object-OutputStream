package ua.ultra;

import java.io.Serializable;

/**
 * Created by Никита on 24.01.2017.
 */
public class Profile implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    private String surname;
}
