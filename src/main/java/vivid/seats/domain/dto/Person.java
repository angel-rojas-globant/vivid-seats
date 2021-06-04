package vivid.seats.domain.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of person
 *
 * @author angel.rojas
 */
public class Person {

    private final String name;

    private final List<Person> friends = new ArrayList<>();

    /**
     * Create a new person with a name
     *
     * @param name
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * get the friends of the person
     *
     * @return
     */
    public List<Person> getFriends() {
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
        if (null != newFriend && this != newFriend) {
            this.friends.add(newFriend);
        }
    }

}
