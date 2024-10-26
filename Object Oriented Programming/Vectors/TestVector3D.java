import org.junit.Test;
import org.junit.Before;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TestVector3D {

    private Vector3D v1;
    private Vector3D v2;

    @Before
    public void setUp(){
        v1 = new Vector3D(1.0,2.0,3.0);
        v2 = new Vector3D(2.0,4.0,6.0);
    }

    @Test
    public void testGetX(){
        assertEquals(1.0, v1.getX(), 0.0);
        assertEquals(2.0, v2.getX(), 0.0);
    }

    @Test
    public void testGetY(){
        assertEquals(2.0, v1.getY(), 0.0);
        assertEquals(4.0, v2.getY(), 0.0);
    }

    @Test
    public void testGetZ(){
        assertEquals(3.0, v1.getZ(), 0.0);
        assertEquals(6.0, v2.getZ(), 0.0);
    }

    @Test
    public void testToString(){
        assertEquals("(1.00, 2.00, 3.00)", v1.toString());
        assertEquals("(2.00, 4.00, 6.00)", v2.toString());
    }

    @Test
    public void testGetMagnitude(){
        assertEquals(3.7416573867739413, v1.getMagnitude(), 0.0);
        assertEquals(7.483314773547883, v2.getMagnitude(), 0.0);
    }

    @Test
    public void testNormalize(){
        Vector3D normalizedVector =
                new Vector3D(0.27, 0.53, 0.80);
        //assertThat(v1.normalize(v1), normalizedVector);
    }

    @Test
    public void testDotProduct(){
        assertEquals(28.0, v1.dotProduct(v1,v2), 0.0);
    }

    @Test
    public void testAngleBetween(){
        assertEquals(0.0, v1.angleBetween(v1,v2), 0.0);
    }





}
