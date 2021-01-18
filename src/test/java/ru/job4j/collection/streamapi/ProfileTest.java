package ru.job4j.collection.streamapi;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfileTest {

    private List<Profile> profiles = new ArrayList<>();

    @Before
    public void setUp() {
        profiles.add(new Profile(new Address("Vladivostok", "Nekrasova", 12, 23)));
        profiles.add(new Profile(new Address("Vladivostok", "Tigrovaya", 20, 232)));
    }

    @Test
    public void whenHaveAddress() {
        Profiles profile = new Profiles();
        List<Address> res = profile.collect(profiles);
        assertThat(res.size(), is(2));
    }
}
