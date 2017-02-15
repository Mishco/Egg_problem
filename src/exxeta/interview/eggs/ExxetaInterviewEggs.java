package exxeta.interview.eggs;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Michal_
 */
public class ExxetaInterviewEggs implements ISkycrapper {

    int vajce = 2;
    int realCountOfFloor = 100;

    int maxFloor;

    public ExxetaInterviewEggs(int maxFloor) {
        this.maxFloor = maxFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         //   ExxetaInterviewEggs t = new ExxetaInterviewEggs(50);
         //    int res = t.fall_new();
         //    System.out.println("Poschodie: "+ res);

         test_1();

    }

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
        System.out.println("Result of test 1: \n correct: " + correct + "\n incorrect: " + incorrect);
    }

    /**
     *
     * @return maximum Floor of unbroken egg
     */
    public int fall() {
        int res = -1;
        int x, y = 25, z = 1;
        boolean tmp = true;

        // set of testing floor 
        Set<Integer> testing_floor = new HashSet<Integer>();

        // adding every floor into set
        for (int i = 1; i < getFloorCount(); i++) {
            testing_floor.add(i);
        }

        for (x = 50; x < getFloorCount(); x++) {
            if (testing_floor.contains(x)) {
                if (testFloor(x)) {
                    if (vajce == 1) {
                        tmp = testFloor(x + 1);
                    } else {
                        tmp = testFloor(x + y);
                    }

                    if (!tmp) {
                        // nothing to do 
                    } else {
                        x = x + y;
                    }

                    // posledne vajce bolo rozbite
                    if (!tmp && vajce <= 1) {
                        res = x;
                        return res;
                    }

                } else {
                    vajce--;
                    y = 1;
                    // posledne vajce bolo rozbite
                    if (vajce <= 0) {
                        // vrat predosle poschodie
                        res = x - 1;
                        return res;
                    }

                    tmp = testFloor(z);

                    if (tmp) {
                        // aby zacalo testovat od prveho poschodia
                        x = z - 1;
                    } else {
                        break;
                    }
                }

                // after test remove item from set
                testing_floor.remove(x);
            }

            if (!tmp) {
                vajce--;
            }

            if (vajce <= 0) {
                break;
            }

            y /= 2;

            if (z >= getFloorCount()) {
                break;
            }
        }
        res = x;
        return res;
    }

    /**
     *
     * @return
     */
    public int fall_new() {
        int res = -1;
        int x, y = 25;
        boolean tmp = true;

        int middle = getFloorCount() / 2;
        for (x = middle; x < getFloorCount(); x++) {
            if (testFloor(x)) {
                if (vajce == 2) {
                    tmp = testFloor(x + y);
                }
                if (vajce == 1) {
                    tmp = testFloor(x + 1);
                }
                if (vajce == 0) {
                    res = x;
                    break;
                }

                if (!tmp) {
                    vajce--;
                    if (vajce == 0) {
                        res = x;
                        break;
                    }

                    x = middle;

                }

            } else {
                vajce--;
                if (vajce == 1) {
                    x = 1;
                } 
                if (vajce == 0) {
                    res = x - 1; // previous floor
                    break;
                }
            }
        }
        return res;
    }

    @Override
    public boolean testFloor(int i) {
        // 74 is true answer
        // if i <= 74 return true, else return false
        // return i <= 74;
        return i <= getMaxFloor();
    }

    @Override
    public int getFloorCount() {
        return realCountOfFloor;
    }

}
