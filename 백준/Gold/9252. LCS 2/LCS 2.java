
import java.util.Scanner;

public class Main {
	static int MATCH = 0;
	static int INSERT = 1;
	static int DELETE = 2;
	static int MAXLEN = 1000;
	static int count = 0;
	static Cell[][] c = new Cell[MAXLEN+1][MAXLEN+1];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String s;
		String t;

		s = scan.nextLine();
		t = scan.nextLine();

		s = " " + s;
		t = " " + t;

		for(int i = 0; i <= MAXLEN; i++) {
			for(int j = 0; j <= MAXLEN; j++) {
				c[i][j] = new Cell(0, 0);
			}
		}

		string_compare(s, t);
		reconstruct_path(s, t, s.length()-1, t.length()-1);
		
		if(count > 0) {
			System.out.println(count);
			System.out.println(sb.toString());
		}
		else {
			System.out.println(count);
		}
	}

	public static int string_compare(String s, String t) {
		int i,j,k;
		int opt[] = new int[3];

		for(i = 0; i <= MAXLEN; i++) {
			row_init(i);
			column_init(i);
		}

		for(i = 1; i < s.length(); i++) {
			for(j = 1; j < t.length(); j++) {
				opt[MATCH] = c[i-1][j-1].cost + match(s.charAt(i), t.charAt(j));
				opt[INSERT] = c[i][j-1].cost + 1;
				opt[DELETE] = c[i-1][j].cost + 1;

				c[i][j].cost = opt[MATCH];
				c[i][j].parent = MATCH;

				for(k = INSERT; k <= DELETE; k++) {
					if(opt[k] < c[i][j].cost) {
						c[i][j].cost = opt[k];
						c[i][j].parent = k;
					}
				}
			}
		}

		return c[s.length()-1][t.length()-1].cost;
	}

	public static int match(char c, char d) {
		if(c == d)
			return 0;
		else
			return MAXLEN;
	}

	public static void row_init(int i) {
		c[0][i].cost = i;
		if(i > 0)
			c[0][i].parent = INSERT;
		else
			c[0][i].parent = -1;
	}

	public static void column_init(int i) {
		c[i][0].cost = i;
		if(i > 0)
			c[i][0].parent = DELETE;
		else
			c[i][0].parent = -1;
	}
	public static void print_matrix(String s, String t, boolean costQ) {
		int i,j;            /* counters */

		System.out.print("   ");
		for (i=0; i<t.length(); i++)
			System.out.print("  "+t.charAt(i));
		System.out.println();

		for (i=0; i<s.length(); i++) {
			System.out.print(s.charAt(i)+": ");
			for (j=0; j<t.length(); j++) {
				if (costQ == true)
					System.out.print("  "+c[i][j].cost);
				else
					System.out.print("  "+c[i][j].parent);
			}
			System.out.println();
		}

	}
	public static void reconstruct_path(String s, String t, int i, int j) {
		if(i < 0 || j < 0 || c[i][j].parent == -1)
			return;

		if(c[i][j].parent == MATCH) {
			reconstruct_path(s, t, i-1, j-1);
			if(s.charAt(i) == t.charAt(j)) {
				sb.append(String.valueOf(s.charAt(i)));
				count++;
			}
			else
				System.out.print("");
			return;
		}
		if(c[i][j].parent == INSERT) {
			reconstruct_path(s, t, i, j-1);
			//System.out.print("I");
			return;
		}
		if(c[i][j].parent == DELETE) {
			reconstruct_path(s, t, i-1, j);
			//System.out.print("D");
			return;
		}
	}
}
class Cell{
	int cost;
	int parent;
	
	public Cell(int cost, int parent) {
		this.cost = cost;
		this.parent = parent;
	}
}