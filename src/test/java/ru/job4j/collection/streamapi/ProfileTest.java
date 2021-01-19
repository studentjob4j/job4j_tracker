package ru.job4j.collection.streamapi;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfileTest {

    private List<Profile> profiles = new ArrayList<>();
    private Address one = new Address("Vladivostok", "Nekrasova", 12, 23);
    private Address two = new Address("Vladivostok", "Nekrasova", 12, 23);
    private Address three = new Address("Moscow", "Tverskaya", 11, 22);

    @Before
    public void setUp() {

        profiles.add(new Profile(one));
        profiles.add(new Profile(two));
        profiles.add(new Profile(three));
    }

    @Test
    public void whenHaveUniqueAddress() {
        Profiles profile = new Profiles();
        List<Address> res = profile.collect(profiles);
        List<Address> except = new ArrayList<>();
        except.add(three);
        except.add(two);
        assertThat(res, is(except));
    }
}
