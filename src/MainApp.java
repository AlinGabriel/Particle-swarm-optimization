/**
 * @author Alin Arhip
 *
 */
public class MainApp {

	public static void main(String[] args) {
		String[] topology = { "graph", "ring", "4neigh" };
		double[] fi1 = { 2.0, 0.8, 0.2 };
		double[] fi2 = { 2.0, 0.2, 0.8 };
		String[] algs = { "pso", "pso_w", "pso_cf" };

		Simulation rosenbrock_sim = new Simulation(new Rosenbrock());
		for (String top : topology) {
			for (int i = 0; i < fi2.length; i++)
				for (String alg : algs) {
					for (int j = 0; j < 10; j++)
						rosenbrock_sim.run(top, fi1[i], fi2[i], alg);
					int bestParticleIndex = rosenbrock_sim.getMinPos();
					System.out.println(rosenbrock_sim.getObjFunction().toString() + "\t" + top + "\tfi1: " + fi1[i]
							+ "\tfi2: " + fi2[i] + "\talg: " + alg + "\tw: " + rosenbrock_sim.weight + "\t\tcf: "
							+ rosenbrock_sim.hi + "\t\t"
							+ rosenbrock_sim.getgBestLocation().get(bestParticleIndex).getX() + "\t"
							+ rosenbrock_sim.getgBestLocation().get(bestParticleIndex).getY() + "\tvalue: "
							+ rosenbrock_sim.getFitnessValueList()[bestParticleIndex]);
				}
		}

		Simulation rastrigin_sim = new Simulation(new Rastrigin());
		for (String top : topology) {
			for (int i = 0; i < fi2.length; i++)
				for (String alg : algs) {
					for (int j = 0; j < 10; j++)
						rastrigin_sim.run(top, fi1[i], fi2[i], alg);
					int bestParticleIndex = rastrigin_sim.getMinPos();
					System.out.println(rastrigin_sim.getObjFunction().toString() + "\t" + top + "\tfi1: " + fi1[i]
							+ "\tfi2: " + fi2[i] + "\talg: " + alg + "\tw: " + rastrigin_sim.weight + "\t\tcf: "
							+ rastrigin_sim.hi + "\t\t" + rastrigin_sim.getgBestLocation().get(bestParticleIndex).getX()
							+ "\t" + rastrigin_sim.getgBestLocation().get(bestParticleIndex).getY() + "\tvalue: "
							+ rastrigin_sim.getFitnessValueList()[bestParticleIndex]);
				}
		}

		Simulation sphere_sim = new Simulation(new Sphere());
		for (String top : topology) {
			for (int i = 0; i < fi2.length; i++)
				for (String alg : algs) {
					for (int j = 0; j < 10; j++)
						sphere_sim.run(top, fi1[i], fi2[i], alg);
					int bestParticleIndex = sphere_sim.getMinPos();
					System.out.println(sphere_sim.getObjFunction().toString() + "\t\t" + top + "\tfi1: " + fi1[i]
							+ "\tfi2: " + fi2[i] + "\talg: " + alg + "\tw: " + sphere_sim.weight + "\t\tcf: "
							+ sphere_sim.hi + "\t\t" + sphere_sim.getgBestLocation().get(bestParticleIndex).getX()
							+ "\t" + sphere_sim.getgBestLocation().get(bestParticleIndex).getY() + "\tvalue: "
							+ sphere_sim.getFitnessValueList()[bestParticleIndex]);
				}
		}

		Simulation grienwank_sim = new Simulation(new Grienwank());
		for (String top : topology) {
			for (int i = 0; i < fi2.length; i++)
				for (String alg : algs) {
					for (int j = 0; j < 10; j++)
						grienwank_sim.run(top, fi1[i], fi2[i], alg);
					int bestParticleIndex = grienwank_sim.getMinPos();
					System.out.println(grienwank_sim.getObjFunction().toString() + "\t" + top + "\tfi1: " + fi1[i]
							+ "\tfi2: " + fi2[i] + "\talg: " + alg + "\tw: " + grienwank_sim.weight + "\t\tcf: "
							+ grienwank_sim.hi + "\t\t" + grienwank_sim.getgBestLocation().get(bestParticleIndex).getX()
							+ "\t" + grienwank_sim.getgBestLocation().get(bestParticleIndex).getY() + "\tvalue: "
							+ grienwank_sim.getFitnessValueList()[bestParticleIndex]);
				}
		}
	}
}
