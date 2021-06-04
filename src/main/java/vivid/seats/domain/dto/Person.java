package vivid.seats.domain.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * Representation of person
 *
 * @author angel.rojas
 */
public class Person {

    private final String name;

    private final Set<Person> friends;

    /**
     * Create a new person with a name
     *
     * @param name
     */
    public Person(String name) {
        this.friends = new HashSet<>();
        this.name = name;
    }

    /**
     * get the friends of the person
     *
     * @return
     */
    public Set<Person> getFriends() {
        return friends;
    }

    /**
     * Get the name of the person
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Add a new friend
     *
     * @param newFriend
     */
    public void addFriend(Person newFriend) {
        this.friends.add(newFriend);
    }

}
