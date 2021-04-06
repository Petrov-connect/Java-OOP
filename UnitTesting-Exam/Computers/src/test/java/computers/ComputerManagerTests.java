package computers;
//created by J.M.

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ComputerManagerTests {

    private static final String manufacturer1="12345";
    private static final String manufacturer2="54321";
    private static final String model1="asdfg";
    private static final String model2=" zxcvb";
    private static final double price1=2.2;
    private static final double price2=5.5;
    private static Computer computer1;
    private static Computer computer2;
    private static ComputerManager computerManager;

    @Before
    public void setUp(){

        computer1 = new Computer(manufacturer1,model1,price1);
        computer2 = new Computer(manufacturer2,model2,price2);
        computerManager = new ComputerManager();
        Main.main(new String[]{"",""});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerMustFailsWhenComputerExist(){
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerMustFailsWhenComputesEqualsNull(){
        computerManager.addComputer(null);

    }

    @Test
    public void testAddComputerShouldAddCorrect(){
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);
        Assert.assertEquals(computer1,computerManager.getComputer(manufacturer1,model1));
        Assert.assertEquals(2,computerManager.getCount());
        List<Computer> computerList=computerManager.getComputers();
        Assert.assertEquals(manufacturer2,computerList.get(1).getManufacturer());
        Assert.assertEquals(model2,computerList.get(1).getModel());
        Assert.assertEquals(price2,computerList.get(1).getPrice(),0.0);
    }

    @Test
    public void testRemoveComputerMustRemoveCorrect(){
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);
        Assert.assertEquals(computer1,computerManager.removeComputer(manufacturer1,model1));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveComputerMustFailsWhenComputerNotExist(){

        Assert.assertNull(computerManager.removeComputer(manufacturer1,model1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputersByManufacturerMustFailsWhenGetNull(){
        computerManager.addComputer(computer2);
        computerManager.getComputersByManufacturer(null);
    }

    @Test
    public void testGetComputersByManufacturerShouldReturnAllComputersWhitThatManufacturer(){
        computerManager.addComputer(computer2);
        computerManager.addComputer(computer1);
        List<Computer>computers=computerManager.getComputersByManufacturer(manufacturer2);
        Assert.assertEquals(computer2,computers.get(0));
    }

}