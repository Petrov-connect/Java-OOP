package p02_ExtendedDatabase;
//created by J.M.

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private static final Person[] PEOPLE = new Person[]{
              new Person(1, "A")
            , new Person(2, "B")
            , new Person(3, "C")
            , new Person(4, "D")
            , new Person(5, "E")
    };
    private static Database database;
    private static final Person testPerson = new Person(6,"F");


    @Before
    public void setUp() throws OperationNotSupportedException {
        database = createDatabase(PEOPLE);
    }

    private Database createDatabase(Person[] elements) throws OperationNotSupportedException {
        return new Database(elements);
    }

    @Test
    public void testConstructorSetAllCorrectParameters() {
        assertEquals(PEOPLE.length, database.getElements().length);
        assertArrayEquals(PEOPLE, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorMustFailWhenParametersIsMoreThen16() throws OperationNotSupportedException {
        createDatabase(new Person[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorMustFailWhenParametersIsLessThen1() throws OperationNotSupportedException {
        createDatabase(new Person[0]);
    }

    @Test
    public void testAddTheElementMustBeAdded() throws OperationNotSupportedException {
        database.add(testPerson);
        assertEquals(PEOPLE.length + 1, database.getElements().length);
        Person actualPerson = database.getElements()[database.getElements().length - 1];
        assertEquals(testPerson.getId(),actualPerson.getId());
        assertEquals(testPerson.getUsername(),actualPerson.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddMustFailWhenParameterIsNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testRemoveElementWhenArrayIsNotEmpty() throws OperationNotSupportedException {
        database.remove();
        assertEquals(PEOPLE.length - 1, database.getElements().length);
        assertEquals(PEOPLE[PEOPLE.length - 2], database.getElements()[database.getElements().length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveWhenArrayLengthIsEmpty() throws OperationNotSupportedException {
        database = createDatabase(new Person[]{ testPerson });
        database.remove();
        database.remove();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameMustFailsWhenNameIsNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameWhenNameIsNotFind() throws OperationNotSupportedException {
        database.findByUsername("Z");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameWhenFindMoreThenOneSameName() throws OperationNotSupportedException {
        database = createDatabase(new Person[]{testPerson,testPerson});
        database.findByUsername(testPerson.getUsername());
    }
    @Test
    public void testFindByUsernameReturnsCorrectObject() throws OperationNotSupportedException {
        assertEquals(PEOPLE[0],database.findByUsername("A"));
    }

    @Test
    public void testFindByIdReturnsCorrectObject() throws OperationNotSupportedException {
        assertEquals(PEOPLE[0],database.findById(1));
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindByIdWhenFindMoreThenOneSameId() throws OperationNotSupportedException {
        database = createDatabase(new Person[]{testPerson,testPerson});
        database.findById(testPerson.getId());
    }

    @Test(expected = OperationNotSupportedException.class )
    public void testFindByIdWhenIdIsNotFind() throws OperationNotSupportedException {
        database.findById(7);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdMustFailsWhenIdIsNull() throws OperationNotSupportedException {
        database=createDatabase(new Person[]{new Person(1,"A")});
        database.remove();
        database.findById(1);
    }
}