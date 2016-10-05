import edu.princeton.cs.algs4.StdIn;

public class Subset {

	public static void main(String[] args) {


		String s = "";
		int n = 0;
		RandomizedQueue<String> rq = new RandomizedQueue<String>();
		
		while(!StdIn.isEmpty()){
			s = StdIn.readString();
			rq.enqueue(s);
			n++;
		}
		
		int a = 0;
		if(args.length == 1){
			a = Integer.parseInt(args[0]) ;
		}else{
			System.out.println("Input Error");
		}
		
		for(int i = 0; i < a ; i++){
			String ss = rq.dequeue();
			System.out.println(ss);
		}
		

	}

}
