package algorithms;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class KnapsackProblemGeneticAlgorithm {

	int[] values;
	int[] weights;
	int capacity;
	static final int POPULATION_SIZE = 6;

	public int[] solve() {

		int[][] population = initPopulation(values.length, POPULATION_SIZE);
		int[] fitness = new int[population.length];

		int bestFitness = -1;
		int[] bestSolution = new int[values.length];
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < population.length; j++) {
				int[] solution = evaluate(values, weights, population[j]);
				if (solution[1] <= capacity) {
					fitness[j] = solution[0];
					if (fitness[j] > bestFitness) {
						bestFitness = fitness[j];
						bestSolution = solution;
					}
				} else {
					fitness[j] = 0;
				}
			}

			population = crossover(population);
			population = mutation(population);
		}
		return bestSolution;

	}

	int[][] crossover(int[][] population) {
		//TODO
		return population;
	}

	int[][] mutation(int[][] population) {
		//TODO
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

	private int[] evaluate(int[] values, int[] weigths, int[] currentSolution) {

		int sumValues = 0;
		int sumWeights = 0;
		for (int i = 0; i < values.length; i++) {
			sumValues += values[i] * currentSolution[i];
			sumWeights += values[i] * currentSolution[i];
		}

		return new int[] { sumValues, sumWeights };
	}

	@Test
	public void test1() {
		this.values = new int[] { 1, 4, 6 };
		this.weights = new int[] { 6, 3, 7 };
		this.capacity = 8;
		int[] solution = solve();
		int[] expected = { 1, 0, 0 };
		assertTrue(Arrays.equals(solution, expected));
	}

}
