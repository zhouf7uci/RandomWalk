import java.util.Scanner;

public class saRandomwalk {
	public static int hl;
    public static void main(String[] pars) {
	Scanner Inp;
	Inp = new Scanner(System.in);
	System.out.print("Give the size of lattice, L:");
	int L = Inp.nextInt();
	hl = L/2;
	System.out.print("Give the number of realizations, R:");
	int R = Inp.nextInt();
	double ret_2d = randomWalk_2d(L,R);
	double sd1 = ret_2d / R;
	System.out.println("The root-mean square distance of 2d randomwalk is:" + sd1);
	double ret_3d = randomWalk_3d(L,R);
	double sd2 = ret_3d / R;
	System.out.println("The root-mean square distance of 3d randomwalk is:" + sd2);
    }
	
	//Build ArrayList with R^2 value of 2d randomWalk.
	private static double randomWalk_2d(int L, int R) {
		int x1=hl;
		int y1=hl;
		double sum1=0;
		boolean isValid=true;
		String[] available_walk = {"N","S","E","W"};
		for (int i1=1; i1<=R; i1++) {
			boolean[][] g1 = new boolean[L][L];
			while ( isValid && x1 > 0 && x1 < L-1 && y1 > 0 && y1 < L-1) {
				if (g1[x1-1][y1] && g1[x1+1][y1] && g1[x1][y1-1] && g1[x1][y1+1]) {
					isValid = false;
				}
				g1[x1][y1] = true;
				java.util.Random random = new java.util.Random();
				int random_walk = random.nextInt(available_walk.length);
				String choice = available_walk[random_walk];
				if (choice == "N") {
					y1 += 1;
				}
				else if (choice == "S") {
					y1 -= 1;
				}
				else if (choice == "E") {
					x1 += 1;
				}
				else {
					x1 -= 1;
				}
			}
			sum1 = sum1 + Math.sqrt((x1-hl)*(x1-hl) + (y1-hl)*(y1-hl));
		}
		return sum1;
	}
	//Build ArrayList with R^2 value of 2d randomWalk.
	private static double randomWalk_3d(int L, int R) {
		int x2 = hl;
		int y2 = hl;
		int z2 = hl;
		double sum2=0;
		boolean isValid=true;
		String[] available_walk = {"N","S","E","W","U","D"};
		for (int i2=1; i2<=R; i2++) {
			boolean[][][] g2 = new boolean[L][L][L];
			while ( isValid && x2>0 && x2<L-1 && y2>0 && y2<L-1 && z2>0 && z2<L-1) {
				if (g2[x2-1][y2][z2] && g2[x2+1][y2][z2] && g2[x2][y2-1][z2] && g2[x2][y2+1][z2] && g2[x2][y2][z2-1] && g2[x2][y2][z2+1]) {
					isValid=false;
				}
				g2[x2][y2][z2] = true;
				java.util.Random random = new java.util.Random();
				int random_walk = random.nextInt(available_walk.length);
				String choice = available_walk[random_walk];
				if (choice == "N") {
					y2 += 1;
				}
				else if (choice == "S") {
					y2 -= 1;
				}
				else if (choice == "E") {
					x2 += 1;
				}
				else if (choice == "W") {
					x2 -= 1;
				}
				else if (choice == "U") {
					z2 += 1;
				}
				else {
					z2 -= 1;
				}
			}
			sum2 = sum2 + Math.sqrt((x2-hl)*(x2-hl) + (y2-hl)*(y2-hl) + (z2-hl)*(z2-hl));
		}
		return sum2;
	}
}