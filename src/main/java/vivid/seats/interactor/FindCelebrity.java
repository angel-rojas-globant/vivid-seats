package vivid.seats.interactor;

import java.util.List;
import java.util.Optional;
import vivid.seats.domain.dto.Person;
import vivid.seats.domain.dto.Team;

/**
 * Service to find the celebrity in a Team
 * 
 * @author angel.rojas
 */
public class FindCelebrity {

    /**
     * Find the celebrity in the team, if there is a celebrity
     * 
     * @param team
     * @return
     */
    public Optional<Person> findCelebrity(Team team) {
        Optional<Person> celebrity = Optional.empty();
        for (Person possibleCelebrity : team.getTheTeam()) {
            //The celebrity does not know anybody, so his/her list is null
            if (possibleCelebrity.getFriends().isEmpty()
                    && this.doTheWholeTeamKnowThePerson(team.getTheTeam(), possibleCelebrity)) {
                celebrity = Optional.of(possibleCelebrity);
                break;
            }
        }
        return celebrity;
    }

    private Boolean doTheWholeTeamKnowThePerson(List<Person> team, Person possibleCelebrity) {
        Boolean everyOneKnowsHimOrHer = Boolean.FALSE;
        for (Person teamMember : team) {
            if (teamMember.equals(possibleCelebrity)) {
                //Do not check the same person with the same person                
            } else if (teamMember.getFriends().contains(possibleCelebrity)) {
                everyOneKnowsHimOrHer = Boolean.TRUE;
            } else {
                everyOneKnowsHimOrHer = Boolean.FALSE;
                break;
            }
        }
        return everyOneKnowsHimOrHer;
    }

}
