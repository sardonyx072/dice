import java.util.stream.IntStream;

public class Die extends DiscreteFunction {
	public enum D {
		D4 (4), D6 (6), D8 (8), D10 (10), D12 (12), D20 (20), D100 (100);
		private int sides;
		private D(int sides) {this.sides = sides;}
		public Die create() {return new Die(this.sides);}
	}
	public Die (int sides) {super(IntStream.rangeClosed(1,sides).mapToLong(i -> 1).toArray(),1);}
	public Die (DiscreteFunction df) {super(df.vals, df.zero);}
}
