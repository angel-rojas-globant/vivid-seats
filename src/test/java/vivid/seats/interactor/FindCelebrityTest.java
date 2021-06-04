package vivid.seats.interactor;

import java.util.Optional;
import org.junit.Test;
import static org.junit.Assert.*;
import vivid.seats.domain.dto.Person;
import vivid.seats.domain.dto.Team;

/**
 *
 * @author angel.rojas
 */
public class FindCelebrityTest {

    /**
     * Test of findCelebrity method, of class FindCelebrity.
     */
    @Test
    public void testFindCelebrityWhenTheListIsEmpty() {
        System.out.println("testFindCelebrityWhenTheListIsEmpty");
        // Arrange
        Team team = new Team();
        FindCelebrity instance = new FindCelebrity();
        // Act
        Optional<Person> result = instance.findCelebrity(team);
        // Assert
        assertFalse(result.isPresent());
    }

    @Test
    public void testFindCelebrityWhenThereIsOnlyPersonInTheTeam() {
        System.out.println("testFindCelebrityWhenThereIsOnlyPersonInTheTeam");
        // Arrange
        Team team = new Team();
        Person mike = new Person("mike");
        team.getTheTeam().add(mike);
        FindCelebrity instance = new FindCelebrity();
        // Act
        Optional<Person> result = instance.findCelebrity(team);
        // Assert
        assertFalse(result.isPresent());
    }

    @Test
    public void testFindCelebrityWhenThereAreTwoPersonInTheTeamAndAllKnowEachOther() {
        System.out.println("testFindCelebrityWhenThereAreTwoPersonInTheTeamAndAllKnowEachOther");
        // Arrange
        Team team = new Team();

        Person mike = new Person("mike");
        team.getTheTeam().add(mike);

        Person jhon = new Person("jhon");
        team.getTheTeam().add(jhon);

        mike.addFriend(jhon);
        jhon.addFriend(mike);

        FindCelebrity instance = new FindCelebrity();
        // Act
        Optional<Person> result = instance.findCelebrity(team);
        // Assert
        assertFalse(result.isPresent());
    }

    @Test
    public void testFindCelebrityWhenThereAreTwoPersonInTheTeamAndMikeIsTheCelebrity() {
        System.out.println("testFindCelebrityWhenThereAreTwoPersonInTheTeamAndMikeIsTheCelebrity");
        // Arrange
        Team team = new Team();

        Person mike = new Person("mike");
        team.getTheTeam().add(mike);

        Person jhon = new Person("jhon");
        team.getTheTeam().add(jhon);
        jhon.addFriend(mike);

        FindCelebrity instance = new FindCelebrity();
        Person expResult = mike;
        // Act
        Optional<Person> result = instance.findCelebrity(team);
        // Assert
        assertTrue(result.isPresent());
        assertEquals(expResult, result.get());
    }

    @Test
    public void testFindCelebrityWhenThereAreThreePersonInTheTeamAndAllKnowEachOther() {
        System.out.println("testFindCelebrityWhenThereAreThreePersonInTheTeamAndAllKnowEachOther");
        // Arrange
        Team team = new Team();

        Person mike = new Person("mike");
        team.getTheTeam().add(mike);

        Person jhon = new Person("jhon");
        team.getTheTeam().add(jhon);

        Person sam = new Person("sam");
        team.getTheTeam().add(sam);

        mike.addFriend(jhon);
        mike.addFriend(sam);

        jhon.addFriend(mike);
        jhon.addFriend(sam);

        sam.addFriend(mike);
        sam.addFriend(jhon);

        FindCelebrity instance = new FindCelebrity();
        // Act
        Optional<Person> result = instance.findCelebrity(team);
        // Assert
        assertFalse(result.isPresent());
    }

    @Test
    public void testFindCelebrityWhenThereAreThreePersonInTheTeamAndMikeIsTheCelebrity() {
        System.out.println("testFindCelebrityWhenThereAreThreePersonInTheTeamAndMikeIsTheCelebrity");
        // Arrange
        Team team = new Team();

        Person mike = new Person("mike");
        team.getTheTeam().add(mike);

        Person jhon = new Person("jhon");
        team.getTheTeam().add(jhon);

        Person sam = new Person("sam");
        team.getTheTeam().add(sam);

        jhon.addFriend(mike);
        jhon.addFriend(sam);

        sam.addFriend(mike);
        sam.addFriend(jhon);

        FindCelebrity instance = new FindCelebrity();
        // Act
        Optional<Person> result = instance.findCelebrity(team);
        // Assert
        assertTrue(result.isPresent());
        assertEquals("mike", result.get().getName());
        assertEquals(mike, mike);
    }

    @Test
    public void testFindCelebrityWhenThereAreThreePersonInTheTeamAndNoEverybodyKnowsMike() {
        System.out.println("testFindCelebrityWhenThereAreThreePersonInTheTeamAndNoEverybodyKnowsMike");
        // Arrange
        Team team = new Team();

        Person mike = new Person("mike");
        team.getTheTeam().add(mike);

        Person jhon = new Person("jhon");
        team.getTheTeam().add(jhon);

        Person sam = new Person("sam");
        team.getTheTeam().add(sam);

        jhon.addFriend(sam);

        sam.addFriend(jhon);

        FindCelebrity instance = new FindCelebrity();
        // Act
        Optional<Person> result = instance.findCelebrity(team);
        // Assert
        assertFalse(result.isPresent());
    }

    @Test
    public void testFindCelebrityWhenThereAreThreePersonInTheTeamAndOnlyOneKnowsMike() {
        System.out.println("testFindCelebrityWhenThereAreThreePersonInTheTeamAndNoEverybodyKnowsMike");
        // Arrange
        Team team = new Team();

        Person mike = new Person("mike");
        team.getTheTeam().add(mike);

        Person jhon = new Person("jhon");
        team.getTheTeam().add(jhon);

        Person sam = new Person("sam");
        team.getTheTeam().add(sam);

        jhon.addFriend(mike);

        sam.addFriend(jhon);

        FindCelebrity instance = new FindCelebrity();
        // Act
        Optional<Person> result = instance.findCelebrity(team);
        // Assert
        assertFalse(result.isPresent());
    }

    @Test
    public void testFindCelebrityWhenThereAreThreePersonInTheTeamAndVerybodyKnowsSamAndMike() {
        System.out.println("testFindCelebrityWhenThereAreThreePersonInTheTeamAndVerybodyKnowsSamAndMike");
        // Arrange
        Team team = new Team();

        Person mike = new Person("mike");
        team.getTheTeam().add(mike);

        Person jhon = new Person("jhon");
        team.getTheTeam().add(jhon);

        Person sam = new Person("sam");
        team.getTheTeam().add(sam);

        jhon.addFriend(sam);
        jhon.addFriend(mike);

        sam.addFriend(mike);

        mike.addFriend(sam);

        FindCelebrity instance = new FindCelebrity();
        // Act
        Optional<Person> result = instance.findCelebrity(team);
        // Assert
        assertFalse(result.isPresent());
    }

}
