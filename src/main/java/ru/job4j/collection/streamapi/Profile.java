package ru.job4j.collection.streamapi;

import java.util.List;
import java.util.stream.Collectors;

public class Profile {

    private Address address;

    public Profile() {
    }

    public Profile(Address address) {
        this.address = address;
    }

    public  List<Address> collect(List<Profile> profiles) {
        List<Address> result = profiles.stream()
                .map(x -> x.address)
                .collect(Collectors.toUnmodifiableList());
        return result;
    }
}
