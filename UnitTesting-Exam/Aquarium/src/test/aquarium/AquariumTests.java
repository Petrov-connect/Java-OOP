package aquarium;
//created by J.M.

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AquariumTests {

    private static final String name1 = "gogo";
    private static final String name2 = "bobo";
    private Fish fish1;
    private Fish fish2;
    private Aquarium aquarium;

    @Before
    public void set() {
        fish1 = new Fish(name1);
        fish2 = new Fish(name2);
        aquarium = new Aquarium("abv", 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMustFailsWhenCapacityIsNotEnough() {

        aquarium.add(fish1);
        aquarium.add(fish2);
        aquarium.add(new Fish("nana"));
    }

    @Test(expected = NullPointerException.class)
    public void testStetNameMustFailsWhenNameIsNull() {

        Aquarium aquarium1 = new Aquarium(null, 2);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameMustFailsNameWhenNameIsEmpty() {

        Aquarium aquarium1 = new Aquarium("  ", 2);
    }

    @Test
    public void testSetNameMUstReturnsCorrectName() {

        Assert.assertEquals("abv", aquarium.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityMustFailsWhenCapacityIsLessThenZero() {

        Aquarium aquarium1 = new Aquarium("abv", -1);
    }

    @Test
    public void testGetCountMustReturnsCorrectCountOfFishInCollection() {

        aquarium.add(fish1);
        aquarium.add(fish2);
        Assert.assertEquals(2, aquarium.getCount());
        Assert.assertEquals(2, aquarium.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveMustFailsWhenGetNotExistName() {

        aquarium.add(fish1);
        aquarium.remove(name1);
        aquarium.remove(name2);
    }

    @Test
    public void testReportMustReturnsCorrectReportOfFishInCollection() {

        aquarium.add(fish1);
        aquarium.add(fish2);
        String expected = "Fish available at abv: gogo, bobo";
        Assert.assertEquals(expected, aquarium.report());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByNameMustFailsWhenGetNonExistName() {

        aquarium.add(fish1);
        Assert.assertEquals(fish1, aquarium.sellFish(name1));
        aquarium.sellFish(name2);
    }

    @Test
    public void testSellFishMustSetFalseIfFishIsSells() {

        aquarium.add(fish1);
        Assert.assertFalse(aquarium.sellFish(name1).isAvailable());
    }
}

