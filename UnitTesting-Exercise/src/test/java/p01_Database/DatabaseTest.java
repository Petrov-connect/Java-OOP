package p01_Database;
//created by J.M.

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private static final Integer[] ELEMENTS = new Integer[]{1, 2, 3, 4, 5};
    private static Database database;


    @Before
    public void setUp() throws OperationNotSupportedException {
        database = createDatabase(ELEMENTS);
    }

    private Database createDatabase(Integer[] elements) throws OperationNotSupportedException {
        return new Database(elements);
    }

    @Test
    public void testConstructorSetAllCorrectParameters() {
        assertEquals(ELEMENTS.length, database.getElements().length);
        assertArrayEquals(ELEMENTS, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorMustFailWhenParametersIsMoreThen16() throws OperationNotSupportedException {
        createDatabase(new Integer[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorMustFailWhenParametersIsLessThen1() throws OperationNotSupportedException {
        createDatabase(new Integer[0]);
    }

    @Test
    public void testAddTheElementMustBeAdded() throws OperationNotSupportedException {
        Integer testInteger = 6;
        database.add(testInteger);
        assertEquals(ELEMENTS.length + 1, database.getElements().length);
        assertEquals(testInteger, database.getElements()[database.getElements().length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddMustFailWhenParameterIsNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testRemoveElementWhenArrayIsNotEmpty() throws OperationNotSupportedException {
        database.remove();
        assertEquals( ELEMENTS.length-1,database.getElements().length);
        assertEquals(ELEMENTS[ELEMENTS.length-2],database.getElements()[database.getElements().length-1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveWhenArrayLengthIsEmpty() throws OperationNotSupportedException {
        database = createDatabase(new Integer[1]);
        database.remove();
        database.remove();
    }
}