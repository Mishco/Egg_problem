package exxeta.interview.eggs;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ExxetaInterviewEggsTest {

    @Test
    public static void test_1() {
        int correct = 0, incorrect = 0;
        for (int idx = 2; idx < 100; idx++) {
            // set maximum floor
            ExxetaInterviewEggs ex = new ExxetaInterviewEggs(idx);

            if (idx == ex.fall_new()) {
                correct++;
            } else {
                incorrect++;
                System.out.print(idx + " ");
            }

        }
        Assertions.assertEquals(98, correct);
        Assertions.assertEquals(0, incorrect);
    }
}