import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine()) - 2;

        int highestNumber = 0;

        List<Integer> sequence = new ArrayList<>();
        sequence.add(0);
        sequence.add(0);

        for (int i = 0; i < input; i++) {

            int lastNumber = sequence.get(sequence.size()-1);

            List<Integer> temp = new ArrayList<>(sequence);
            temp.remove(temp.size()-1);

            if (!temp.contains(lastNumber)){
                sequence.add(0);
            } else {
                int steps = sequence.size()-1 - temp.lastIndexOf(lastNumber);
                sequence.add(steps);
                if (steps>highestNumber){
                    highestNumber = steps;
                }
            }

        }

        System.out.println("Sequence:");
        System.out.println(sequence.toString().replaceAll("[\\[\\],]", ""));
        System.out.printf("Highest number: %d%n", highestNumber);
        int test = sequence.get(sequence.lastIndexOf(highestNumber) - 1);
        System.out.printf("The number before that: %d%nPositions of number %d:", test, test);

        for (int i = 0; i < sequence.size()-1; i++) {
            if (sequence.get(i) == test){
                System.out.printf(" %d", i);
            }
        }
    }
}
