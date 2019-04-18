import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BarnRepairTest {
    private int numTests = 10;
    private int M, S, C;
    private int[] occupied;
    private int[] answers = {21, 6, 20, 9, 10, 6, 118, 180, 100, 200};

    public static BufferedReader readTestFile(String name) throws IOException {
        String slash = File.separator;
        String filename = System.getProperty("user.dir") + slash +
                "test" + slash + "files" + slash + name;
        return new BufferedReader(new FileReader(filename));
    }

    @Test
    public void run() throws IOException {
        BufferedReader f = readTestFile("barnrepair.test");
        StringTokenizer st;
        int solution;
        boolean passed = true;

        for (int t = 0; t < numTests; t++) {
            f.readLine();
            st = new StringTokenizer(f.readLine());
            M = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            occupied = new int[C];

            for (int i = 0; i < C; i++)
                occupied[i] = Integer.parseInt(f.readLine());

            solution = BarnRepair.solve(M, occupied);
            System.out.print("Test case " + t);

            if (solution != answers[t]) {
                System.out.println(" fails");
                passed = false;
            } else {
                System.out.println(" passes");
            }
        }

        assert passed;
    }
}
