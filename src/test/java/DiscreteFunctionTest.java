import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class DiscreteFunctionTest {
	
	@Test
	public void testConstructor() {
		DiscreteFunction df1 = new DiscreteFunction(new long[] {0}, 0);
		System.out.println("df1\n"+df1);
		Assert.assertArrayEquals(new double[] {0,0,0}, new double[] {df1.get(-1),df1.get(0),df1.get(1)},0.0001);
		DiscreteFunction df2 = new DiscreteFunction(new long[] {1}, 0);
		System.out.println("df2\n"+df2);
		Assert.assertArrayEquals(new double[] {0,100,0}, new double[] {df2.get(-1),df2.get(0),df2.get(1)},0.0001);
		DiscreteFunction df3 = new DiscreteFunction(new long[] {0,1,0}, 0);
		System.out.println("df3\n"+df3);
		Assert.assertArrayEquals(new double[] {0,0,100,0}, new double[] {df3.get(-1),df3.get(0),df3.get(1),df3.get(2)},0.0001);
		DiscreteFunction df4 = new DiscreteFunction(new long[] {1,1,0}, 0);
		System.out.println("df4\n"+df4);
		Assert.assertArrayEquals(new double[] {0,50,50,0}, new double[] {df4.get(-1),df4.get(0),df4.get(1),df4.get(2)},0.0001);
		DiscreteFunction df5 = new DiscreteFunction(new long[] {1,1,0}, -1);
		System.out.println("df5\n"+df5);
		Assert.assertArrayEquals(new double[] {0,50,50,0}, new double[] {df5.get(-2),df5.get(-1),df5.get(0),df5.get(1)},0.0001);
	}

}
