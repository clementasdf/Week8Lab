import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class workstations {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        PriorityQueue<Integer> comMinHeap = new PriorityQueue<>();
        int counter = 0;
        int N = io.getInt();
        int lockTime = io.getInt();
        comMinHeap.add(io.getInt() + io.getInt() + lockTime); // adding the very first dude
        int[][] researcherArray = new int[N][2];
        for (int i = 1; i < N; i++) {
            int[] temp = {io.getInt(), io.getInt()};
            researcherArray[i] = temp;
        }
        Arrays.sort(researcherArray);
        for (int i = 1; i < N-1; i++) {
            int arrival = researcherArray[i][0];
            int useTime = researcherArray[i][1];
            int sum = arrival + useTime + lockTime;
            while (!comMinHeap.isEmpty()) {
                if (arrival > comMinHeap.peek()) {
                    comMinHeap.remove();
                } else if (arrival >= comMinHeap.peek() - lockTime) {
                    counter++;
                    comMinHeap.remove();
                    comMinHeap.add(sum);
                    break;
                } else {
                    comMinHeap.add(sum);
                    break;
                }
            }
        }
        io.println(counter);
        io.close();

    }
}
