import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class lab13 {
	private ArrayList<Integer> arr = new ArrayList<Integer>();
	
	public void readData(String fileName){
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			ArrayList<Integer> temp = new ArrayList<>();
			String inn;
			while((inn = br.readLine()) != null) {
				Integer i = Integer.parseInt(inn);
				arr.add(i);
			}
			br.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public long getTotalCount() {
		return arr.stream().count();
	}
	
	public long getOddCount() {
		return arr.stream().filter(x -> x % 2 == 1).count();
	}
	
	public long getEvenCount() {
		return arr.stream().filter(x -> x % 2 == 0).count();
	}
	
	public long getDistinctGreaterThanFiveCount() {
		return arr.stream().filter(x -> x > 5).distinct().count();
	}
	
	public Integer[] getResult1() {
		return arr.stream().filter(x -> (x > 5) && (x < 50) && (x % 2 == 0)).sorted().toArray(Integer[] :: new);
	}
	
	public Integer[] getResult2() {
		return arr.stream().limit(50).map(x -> 3*(x*x)).toArray(Integer[] :: new);
	}


	public Integer[] getResult3() {
		return arr.stream().filter(x -> x % 2 == 1).map(x -> 2*x).sorted().skip(20).distinct().toArray(Integer[] :: new);
	}
	
}
