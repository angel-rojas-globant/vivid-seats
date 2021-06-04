package vivid.seats.interactor;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    @Test()
    @DisplayName("Test to Find Celebrity When The Team Is Empty")
    public void testFindCelebrityWhenTheListIsEmpty() {
        // Arrange
        Team team = new Team();
        FindCelebrity instance = new FindCelebrity();
        // Act
        Optional<Person> result = instance.findCelebrity(team);
        // Assert
        assertFalse(result.isPresent());
    }

    @Test
    @DisplayName("Test to Find Celebrity When There Is Only One Person In The Team")
    public void testFindCelebrityWhenThereIsOnlyOnePersonInTheTeam() {
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
    @DisplayName("Test to Find Celebrity When There Are Two Persons In The Team And All Know Each Other")
    public void testFindCelebrityWhenThereAreTwoPersonInTheTeamAndAllKnowEachOther() {
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
    @DisplayName("Test to Find Celebrity When There Are Two Persons In The Team And Mike Is The Celebrity")
    public void testFindCelebrityWhenThereAreTwoPersonInTheTeamAndMikeIsTheCelebrity() {
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
    @DisplayName("Test to Find Celebrity When There Are Three Persons In The Team And Know Each Other")
    public void testFindCelebrityWhenThereAreThreePersonInTheTeamAndAllKnowEachOther() {
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
    @DisplayName("Test to Find Celebrity When There Are Three Persons In The Team And Mike is The Celebrity")
    public void testFindCelebrityWhenThereAreThreePersonInTheTeamAndMikeIsTheCelebrity() {
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
    @DisplayName("Test to Find Celebrity When There Are Three Persons In The Team No One Know Mike, "
            + "but the rest know each other")
    public void testFindCelebrityWhenThereAreThreePersonInTheTeamAndNoOneKnowsMike() {
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
    @DisplayName("Test to Find Celebrity When There Are Three Persons In The Team And Only One Knows Mike")
    public void testFindCelebrityWhenThereAreThreePersonInTheTeamAndOnlyOneKnowsMike() {
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
    @DisplayName("Test to Find Celebrity When There Are Three Persons In The Team And Everybody"
            + " knows Sam and Mike")
    public void testFindCelebrityWhenThereAreThreePersonInTheTeamAndEverybodyKnowsSamAndMike() {
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
