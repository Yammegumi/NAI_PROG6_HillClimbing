import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TravelingSalesman {
    private int numberOfCities;
    private int[][] distances;
    private List<Integer> tour;

    public TravelingSalesman(String filename) throws IOException {
        loadFile(filename);
        tour = new ArrayList<>();
        for (int i = 0; i < numberOfCities; i++) {
            tour.add(i);
        }
        Collections.shuffle(tour);
    }

    private void loadFile(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            numberOfCities = Integer.parseInt(br.readLine());
            distances = new int[numberOfCities][numberOfCities];

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int city1 = Integer.parseInt(parts[0]);
                int city2 = Integer.parseInt(parts[1]);
                int distance = Integer.parseInt(parts[2]);
                distances[city1][city2] = distance;
                distances[city2][city1] = distance;
            }
        }
    }

    private int calculateTourDistance(List<Integer> tour) {
        int totalDistance = 0;
        for (int i = 0; i < tour.size() - 1; i++) {
            totalDistance += distances[tour.get(i)][tour.get(i + 1)];
        }
        totalDistance += distances[tour.get(tour.size() - 1)][tour.get(0)];
        return totalDistance;
    }

    public void solveProblem() {
        int currentDistance = calculateTourDistance(tour);
        int iterations = 0;

        while (true) {
            int bestDistance = currentDistance;
            int bestI = -1, bestJ = -1;

            for (int i = 0; i < numberOfCities - 1; i++) {
                for (int j = i + 1; j < numberOfCities; j++) {
                    Collections.swap(tour, i, j);
                    int newDistance = calculateTourDistance(tour);
                    if (newDistance < bestDistance) {
                        bestDistance = newDistance;
                        bestI = i;
                        bestJ = j;
                    }
                    Collections.swap(tour, i, j);
                }
            }

            if (bestDistance < currentDistance) {
                Collections.swap(tour, bestI, bestJ);
                currentDistance = bestDistance;
                iterations++;
                System.out.println("Iteration: " + iterations + ", Best Distance: " + currentDistance + ", Best route : " + tour);
            } else {
                break;
            }
        }
    }
}