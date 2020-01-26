import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) {
		
	List<String> arr = new ArrayList<String>();
	
	arr.add("a");
	arr.add("b");
	arr.add("c");
	arr.add("d");
	
	while(!arr.isEmpty()) {
		System.out.println(arr.remove(0));
	}
		

	}

}
