import java.util.Scanner;

public class PipefyChallenge {
	final boolean[][][] templates = new boolean[10][][];
	final boolean[] notDivFirst = new boolean[10];	
	final int[] divCounts = new int[10];

	PipefyChallenge() {
		templates[2] = new boolean[2][2];
		templates[2][0][1] = true;
		templates[2][1][0] = true;
		
		templates[3] = new boolean[2][3];
		templates[3][0][2] = true;
		templates[3][1][2] = true;

		templates[4] = new boolean[2][4];
		templates[4][0][0] = true;
		templates[4][0][3] = true;
		templates[4][1][3] = true;

		templates[5] = new boolean[2][5];
		templates[5][0][0] = true;
		templates[5][1][4] = true;

		templates[6] = new boolean[2][6];
		templates[6][0][0] = true;
		templates[6][1][0] = true;
		templates[6][1][5] = true;

		templates[7] = new boolean[1][7];
		templates[7][0][6] = true;
		
		templates[8] = new boolean[2][8];
		templates[8][0][0] = true;
		templates[8][0][7] = true;		
		templates[8][1][0] = true;
		templates[8][1][7] = true;

		templates[9] = new boolean[2][9];
		templates[9][0][0] = true;
		templates[9][0][8] = true;		
		templates[9][1][8] = true;

		divCounts[2] = 3;
		divCounts[3] = 3;
		divCounts[4] = 1;
		divCounts[5] = 3;
		divCounts[6] = 3;
		divCounts[7] = 1;
		divCounts[8] = 3;
		divCounts[9] = 3;
		
		notDivFirst[4] = true;
	}

	public static void main(String[] args) {
		String errorMessage = "Input must be a number between 1 and 9 inclusive.";
		
		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {
			try {
				int n = Integer.parseInt(in.next());
				
				if (n == 1) System.out.println(1);
				else if (n > 1 && n < 10) new PipefyChallenge().printN(n);
				else System.out.println(errorMessage);
			} catch (Exception e) {
				System.out.println(errorMessage);
			}
		}	
	}

	void printN(int n) {
		StringBuilder out = new StringBuilder();

		int divCount = divCounts[n];
		
		if (!notDivFirst[n]) {
			appendDivisor(n, out);
			divCount--;
		}

		for (int i = 0; i < templates[n].length; i++) {
			for (int t = 0; t < n; t++) {
				for (int j = 0; j < templates[n][i].length; j++) {
					if (templates[n][i][j])
						out.append(n);
					else
						out.append(" ");
				}
				
				out.append("\n");
			}

			if (divCount-- > 0)
				appendDivisor(n, out);				
		}

		System.out.print(out.toString());	
	}

	void appendDivisor(int n, StringBuilder out) {
		out.append(String.format("%1$" + n + "d\n", n).replace(" ", String.valueOf(n)));
	}
}
