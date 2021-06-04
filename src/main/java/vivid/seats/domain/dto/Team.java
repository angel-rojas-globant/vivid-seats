package vivid.seats.domain.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of a team where members and maybe celebrities are.
 *
 * @author angel.rojas
 */
public class Team {

    private final List<Person> theTeam = new ArrayList<>();

    /**
     * Get The whole team
     *
     * @return
     */
    public List<Person> getTheTeam() {
        return theTeam;
    }
}
