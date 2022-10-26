import java.util.*; import java.io.*;

public class USACOTheGreatRevegetation {
	
	static int n, m, a[][], res[];
	static String ans;
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static boolean no[][], nope[];
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader("revegetate.in"));
		out = new PrintWriter("revegetate.out");
		
		init();
		solve();
		out.println(ans);
		
		in.close();
		out.close();
	}
	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new int[m][2];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());
		}
		
		no = new boolean[n][n];
		for(int i = 0; i < m; i++) {
			no[a[i][0]-1][a[i][1]-1] = true;
			no[a[i][1]-1][a[i][0]-1] = true;
		}
		
		res = new int[n];
		Arrays.fill(res, 0);

	}
	static void solve() {
		
		for(int i = 0; i < n; i++) { // current pasture
			nope = no[i];
			String contains = "";
			for(int j = 0; j < nope.length; j++) { // different pastures
				if(nope[j]) {
					contains += res[j];
				}
			}
			
			int available = 1;
			while(true) {
				if(!contains.contains(available+"")) {
					res[i] = available;
					break;
				}
				available++;
			}
		}
		
		ans="";
		for(int i = 0; i < n; i++) {
			ans+=res[i];
		}
	}
}
