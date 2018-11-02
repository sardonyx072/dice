import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class DiscreteFunction {
	private long[] vals;
	private int zero;
	
	public DiscreteFunction (long[] vals, int zero) {
		int start = 0, end = vals.length;
		while (start<vals.length-1 && vals[start]==0) start++;
		while (end-1>0 && vals[end-1]==0) end--;
		this.vals = Arrays.copyOfRange(vals,start,end);
		this.zero = zero+start;
	}
	public long[] raw() {return this.vals;}
	public int xMax() {return this.zero+this.vals.length-1;}
	public int xMin() {return this.zero;}
	public long yMax() {return LongStream.of(this.vals).max().getAsLong();}
	public long yMin() {return LongStream.of(this.vals).min().getAsLong();}
	public double get(int x) {
		try {
			long div = LongStream.of(this.vals).sum();
			return div==0 ? 0 : (this.vals[x-this.zero]*100.0)/div;
		} catch(Exception e) {
			return 0;
		}
	}
	public DiscreteFunction inverse() {
		return new DiscreteFunction(IntStream.rangeClosed(1, this.vals.length).mapToLong(i -> this.vals[this.vals.length - i]).toArray(),-1*this.xMax());
	}
	public DiscreteFunction convolve(DiscreteFunction arg0) {
		int zero = this.zero + arg0.zero;
		long[] vals = new long[this.xMax()+arg0.xMax()-zero+1];
		for (int i = 0; i < arg0.vals.length; i++)
			for (int j = 0; j < this.vals.length; j++)
				vals[i+j] += this.vals[j]*arg0.vals[i];
		return new DiscreteFunction(vals, zero);
	}
	public String toString() {
		int width = Math.max(String.valueOf(this.xMin()).length(), Math.max(String.valueOf(this.xMax()).length(), String.valueOf(this.yMax()).length()))+1;
		String fmt = "%1$-"+width+"s";
		StringBuilder str = new StringBuilder();
		LongStream.of(this.vals).forEach(i -> str.append(String.format(fmt, i)));
		str.append("\n");
		IntStream.rangeClosed(this.xMin(), this.xMax()).forEach(i -> str.append(String.format(fmt, "|").replace(' ', '-')));
		str.append("\n");
		IntStream.rangeClosed(this.xMin(), this.xMax()).forEach(i -> str.append(String.format(fmt, i)));
		return str.toString();
	}
}
