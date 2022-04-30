package algorithms.knapsackproblem;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class KnapsackProblemGeneticAlgorithm {

	Random random = new Random();
	int[] values;
	int[] weights;
	int capacity;
	static final int POPULATION_SIZE = 20;

	static final double crossoverRate = 0.2; // 10%
	static final double mutationRate = 0.35; // 3%

	public int[] solve() {

		int[][] population = initPopulation(values.length, POPULATION_SIZE);
		int[] fitness = new int[population.length];

		int bestFitness = -1;
		int indBest = -1;
		int[] bestSolution = new int[values.length];
		for (int i = 0; i < 10000000; i++) {
			for (int j = 0; j < population.length; j++) {
				int[] solution = evaluate(population[j]);
				if (solution[1] <= capacity) {
					fitness[j] = solution[0];
				} else {
					fitness[j] = 0;
				}
				if (fitness[j] > bestFitness) {
					bestFitness = fitness[j];
					bestSolution = solution;
					indBest = j;
				}
			}
			System.out.println("best = " + bestFitness + ", weight=" + evaluate(population[indBest])[1]);

			population = crossover(population, fitness);
			population = mutation(population);
		}
		return bestSolution;

	}

	int[][] crossover(int[][] population, int[] fitness) {

		int numberOfCrossovers = (int) Math.floor(crossoverRate * POPULATION_SIZE);

		for (int i = 0; i < numberOfCrossovers; i++) {
			int ind1 = random.nextInt(POPULATION_SIZE);
			int ind2;
			while ((ind2 = random.nextInt(POPULATION_SIZE)) == ind1);
				
			int indCrossover = random.nextInt(values.length);
			int[] parent1 = population[ind1];
			int[] parent2 = population[ind2];
			int[] new1 = new int[values.length];
			int[] new2 = new int[values.length];
			for (int j = 0; j < indCrossover; j++) {
				new1[j] = parent1[j];
				new2[j] = parent2[j];
			}
			for (int j = indCrossover + 1; j < values.length; j++) {
				new1[j] = parent2[j];
				new2[j] = parent1[j];
			}
			population[ind1] = new1;
			population[ind2] = new2;
		}
		return population;
	}

	int[][] mutation(int[][] population) {
		for (int i=0; i<population.length; i++) {
			double value = new Random().nextDouble();
			if (value <= mutationRate) {
				int index = new Random().nextInt(values.length);
				if (population[i][index] == 1) {
					population[i][index] = 0;
				} else {
					population[i][index] = 1;
				}
			}
		}
		return population;
	}

	private int[][] initPopulation(int size, int numberOfIndividuals) {
		Random random = new Random();
		int[][] population = new int[numberOfIndividuals][size];
		for (int i = 0; i < numberOfIndividuals; i++) {
			for (int j = 0; j < size; j++) {
				int value = random.nextBoolean() ? 1 : 0;
				population[i][j] = value;
			}
		}
		return population;
	}

	private int[] evaluate(int[] currentSolution) {

		int sumValues = 0;
		int sumWeights = 0;
		for (int i = 0; i < values.length; i++) {
			sumValues += values[i] * currentSolution[i];
			sumWeights += weights[i] * currentSolution[i];
		}

		return new int[] { sumValues, sumWeights };
	}

	@Test
	public void test1() {
		this.values = new int[] {  1, 4, 6, 10, 15, 26, 31, 8, 11, 8, 33, 45, 81, 9, 17, 14, 25, 28, 31, 2, 7, 112, 87 };
		this.weights = new int[] { 6, 3, 7, 23,  2,  3,  4, 9,  4, 1,  5,  4,  6, 11, 10, 5, 8,  4,   4, 1, 2,  47,  9 };
		this.capacity = 199;
		int[] solution = solve();
		int[] expected = { 1, 0, 0 };
		assertTrue(Arrays.equals(solution, expected));
	}

}
