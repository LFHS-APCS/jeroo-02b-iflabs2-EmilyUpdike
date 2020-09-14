import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import java.io.*;

/**
 *
 * @author  Aronson
 */
public class TestMain implements Directions
{
    public static void main(String args[]) {
        TestMain test = new TestMain();
        test.setup();
        test.test1_pickRectangle();
        test.test2_disableNet();
        test.test3_hopCheckFlowersOr();
        test.test4_hopCheckFlowersAnd();
    }

    @Before
    public void setup() {
        Map.getInstance().loadMap("maps/ifLabs2.jev");
    }

    @Test
    public void test1_pickRectangle()
    {   
        Jeroo j1 = new Jeroo(2, 1, EAST, 0);
        j1.pickRectangle();
        assertTrue("should be no flower at (2, 2)", !Map.getInstance().isFlower(2,2));
        assertTrue("should be no flower at (2, 3)", !Map.getInstance().isFlower(2,3));
        assertTrue("should be no flower at (2, 4)", !Map.getInstance().isFlower(2,4));
        assertTrue("should be no flower at (3, 2)", !Map.getInstance().isFlower(3,2));
        assertTrue("should be no flower at (3, 3)", !Map.getInstance().isFlower(3,3));
        assertTrue("should be no flower at (3, 4)", !Map.getInstance().isFlower(3,4));
        assertTrue("should be no flower at (4, 2)", !Map.getInstance().isFlower(4,2));
        assertTrue("should be no flower at (4, 3)", !Map.getInstance().isFlower(4,3));
        assertTrue("should be no flower at (4, 4)", !Map.getInstance().isFlower(4,4));
        assertTrue("should be no flower at (5, 2)", !Map.getInstance().isFlower(5,2));
        assertTrue("should be no flower at (5, 3)", !Map.getInstance().isFlower(5,3));
        assertTrue("should be no flower at (5, 4)", !Map.getInstance().isFlower(5,4));

    }

    @Test
    public void test2_disableNet() {
        Jeroo j1 = new Jeroo(4, 7, NORTH, 1);
        j1.disableNet();
        assertTrue("should be no flower at (3, 7)", !Map.getInstance().isFlower(3, 7));
        assertTrue("should be a flower at (4, 7)", Map.getInstance().isFlower(4, 7));
        assertTrue("should be Jeroo at (4, 7)", Map.getInstance().isJeroo(4, 7));

        Jeroo j2 = new Jeroo(4, 8, NORTH, 0);
        j2.disableNet();
        assertTrue("should be no net at (3, 8)", !Map.getInstance().isNet(3, 8));
        assertTrue("should be no flower at (4, 8)", !Map.getInstance().isFlower(4, 8));
        assertTrue("should be Jeroo at (3, 8)", Map.getInstance().isJeroo(3, 8));

        Jeroo j3 = new Jeroo(4, 9, NORTH, 0);
        j3.disableNet();
        assertTrue("should be no flower at (3, 9)", !Map.getInstance().isFlower(3, 9));
        assertTrue("should be a net at (3, 9)", Map.getInstance().isNet(3, 9));
        assertTrue("should be Jeroo at (4, 9)", Map.getInstance().isJeroo(4, 9));

    }

    @Test
    public void test3_hopCheckFlowersOr() {
        Jeroo j1 = new Jeroo(8, 3, NORTH, 0);
        j1.hopCheckFlowersOr();
        assertTrue("should be Jeroo at (7, 3)", Map.getInstance().isJeroo(7, 3));

        Jeroo j2 = new Jeroo(8, 6, NORTH, 0);
        j2.hopCheckFlowersOr();
        assertTrue("should be Jeroo at (7, 6)", Map.getInstance().isJeroo(7, 6));

        Jeroo j3 = new Jeroo(8, 9, NORTH, 0);
        j3.hopCheckFlowersOr();
        assertTrue("should be Jeroo at (7, 9)", Map.getInstance().isJeroo(7, 9));

        Jeroo j4 = new Jeroo(8, 12, NORTH, 0);
        j4.hopCheckFlowersOr();
        assertTrue("should be Jeroo at (8, 12)", Map.getInstance().isJeroo(8, 12));
    }

    @Test
    public void test4_hopCheckFlowersAnd() {
        Jeroo j1 = new Jeroo(8, 3, NORTH, 0);
        j1.hopCheckFlowersOr();
        assertTrue("should be Jeroo at (8, 3)", Map.getInstance().isJeroo(8, 3));

        Jeroo j2 = new Jeroo(8, 6, NORTH, 0);
        j2.hopCheckFlowersOr();
        assertTrue("should be Jeroo at (7, 6)", Map.getInstance().isJeroo(7, 6));

        Jeroo j3 = new Jeroo(8, 9, NORTH, 0);
        j3.hopCheckFlowersOr();
        assertTrue("should be Jeroo at (8, 9)", Map.getInstance().isJeroo(8, 9));

        Jeroo j4 = new Jeroo(8, 12, NORTH, 0);
        j4.hopCheckFlowersOr();
        assertTrue("should be Jeroo at (8, 12)", Map.getInstance().isJeroo(8, 12));
    }

}
