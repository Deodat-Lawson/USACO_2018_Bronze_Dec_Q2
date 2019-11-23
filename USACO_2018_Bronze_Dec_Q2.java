import java.util.*;
import java.io.*;

public class USACO_2018_Bronze_Dec_Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("blist.in"));
        ArrayList<Integer> start = new ArrayList<>();
        ArrayList<Integer> end = new ArrayList<>();
        ArrayList<Integer> numOfBuckets = new ArrayList<>();

        int numberOfCows = Integer.parseInt(br.readLine());

        for (int i = 0; i < numberOfCows; i++) {
            String cow = br.readLine();
            StringTokenizer tok = new StringTokenizer(cow);
            start.add(Integer.parseInt(tok.nextToken()));
            end.add(Integer.parseInt(tok.nextToken()));
            numOfBuckets.add(Integer.parseInt(tok.nextToken()));
        }
        br.close();

        int smallestNumber = Integer.MAX_VALUE;
        int biggestNumber = Integer.MIN_VALUE;
//find smallest value
        for (int i = 0; i < numberOfCows; i++) {
            if (start.get(i) < smallestNumber) {
                smallestNumber = start.get(i);
            }
        }
//find biggest value
        for (int i = 0; i < numberOfCows; i++) {
            if (end.get(i) > biggestNumber) {
                biggestNumber = end.get(i);
            }
        }
        //calculations
        int maxBucketNum = 0;
        for (int i = smallestNumber; i < biggestNumber; i++) {
            int maxBucketToSatisfy = 0;
            for (int j = 0; j < numberOfCows; j++) {
                if (start.get(j) <= i && end.get(j) >= i) maxBucketToSatisfy += numOfBuckets.get(j);
            }
            if (maxBucketToSatisfy > maxBucketNum) {
                maxBucketNum = maxBucketToSatisfy;
            }
        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
        out.println(maxBucketNum);
        out.close();
    }
}