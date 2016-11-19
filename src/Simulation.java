import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Alin Arhip
 *
 */
public class Simulation implements Constants {
	private ObjFunction objFunction;
	private List<Particle> swarm;
	private double[] fitnessValueList;
	private double[] pBest;
	private List<Location> pBestLocation;
	private double[] gBest = new double[SWARM_SIZE];
	private List<Location> gBestLocation;
	double weight;
	double hi;

	public Simulation(ObjFunction objFunction) {
		this.objFunction = objFunction;
		swarm = new ArrayList<Particle>();
		fitnessValueList = new double[SWARM_SIZE];
		pBest = new double[SWARM_SIZE];
		pBestLocation = new ArrayList<Location>();
		gBestLocation = new ArrayList<Location>();
	}

	public ObjFunction getObjFunction() {
		return objFunction;
	}

	public List<Location> getgBestLocation() {
		return gBestLocation;
	}

	public double[] getFitnessValueList() {
		return fitnessValueList;
	}

	public void run(String topology, double fi1, double fi2, String alg) {
		weight = 1.0;
		hi = 1.0;
		initializeSwarm();

		for (int t = 0; t < MAX_ITERATION; t++) {
			// step 1 - update pBest
			for (int i = 0; i < SWARM_SIZE; i++)
				if (fitnessValueList[i] < pBest[i]) {
					pBest[i] = fitnessValueList[i];
					pBestLocation.set(i, swarm.get(i).getLocation());
				}

			// step 2 - update gBest
			if (topology.equals("graph")) {
				int bestParticleIndex = getMinPos();
				if (t == 0 || fitnessValueList[bestParticleIndex] < gBest[0]) {
					for (int i = 0; i < SWARM_SIZE; i++) {
						gBest[i] = fitnessValueList[bestParticleIndex];
						gBestLocation.add(i, swarm.get(bestParticleIndex).getLocation());
					}
				}
			} else if (topology.equals("ring") || topology.equals("4neigh")) {
				for (int i = 0; i < SWARM_SIZE; i++) {
					if (t == 0) {
						gBest[i] = fitnessValueList[i];
						gBestLocation.add(i, swarm.get(i).getLocation());
					} else {
						int bestParticleIndex = getMinPosNeigh(topology, i);
						gBest[i] = fitnessValueList[bestParticleIndex];
						gBestLocation.add(i, swarm.get(bestParticleIndex).getLocation());
					}
				}
			}

			// update weight
			if (alg.equals("pso_w"))
				weight = W_MAX - (((double) t) / MAX_ITERATION) * (W_MAX - W_MIN) - 0.005;
			else if (alg.equals("pso_cf"))
				hi = 0.7;

			for (int i = 0; i < SWARM_SIZE; i++) {
				Particle particle = swarm.get(i);
				Random random = new Random();
				double r1 = random.nextDouble();
				double r2 = random.nextDouble();

				// step 3 - update velocity
				double[] newVelocity = new double[PROBLEM_DIMENSION];
				newVelocity[0] = hi * (weight * particle.getVelocity().getVelocity()[0])
						+ r1 * fi1 * (pBestLocation.get(i).getX() - particle.getLocation().getX())
						+ r2 * fi2 * (gBestLocation.get(i).getX() - particle.getLocation().getX());
				newVelocity[1] = hi * (weight * particle.getVelocity().getVelocity()[1])
						+ (r1 * fi1) * (pBestLocation.get(i).getY() - particle.getLocation().getY())
						+ (r2 * fi2) * (gBestLocation.get(i).getY() - particle.getLocation().getY());
				particle.setVelocity(new Velocity(newVelocity));

				// step 4 - update location
				double[] newLocation = new double[PROBLEM_DIMENSION];
				newLocation[0] = particle.getLocation().getX() + newVelocity[0];
				newLocation[1] = particle.getLocation().getY() + newVelocity[1];
				particle.setLocation(new Location(newLocation));
			}

			// System.out.println("ITERATION " + t + ": ");

		}

	}

	private int getMinPosNeigh(String topology, int i) {
		int prev = ((i - 1) + SWARM_SIZE) % SWARM_SIZE;
		int next = ((i + 1) + SWARM_SIZE) % SWARM_SIZE;
		int minIndex = next;

		if (fitnessValueList[prev] < fitnessValueList[minIndex])
			minIndex = prev;
		if (fitnessValueList[i] < fitnessValueList[minIndex])
			minIndex = i;

		if (topology.equals("4neigh")) {
			int prev2 = ((i - 2) + SWARM_SIZE) % SWARM_SIZE;
			int next2 = ((i + 2) + SWARM_SIZE) % SWARM_SIZE;

			if (fitnessValueList[prev2] < fitnessValueList[minIndex])
				minIndex = prev2;
			if (fitnessValueList[next2] < fitnessValueList[minIndex])
				minIndex = next2;
		}

		return minIndex;
	}

	public int getMinPos() {
		int pos = 0;
		double minValue = fitnessValueList[0];

		for (int i = 0; i < fitnessValueList.length; i++) {
			if (fitnessValueList[i] < minValue) {
				minValue = fitnessValueList[i];
				pos = i;
			}
		}

		return pos;
	}

	/* initialize swarm, FitnessValueList, personal best value and location */
	private void initializeSwarm() {
		Random random = new Random();
		for (int i = 0; i < SWARM_SIZE; i++) {

			double[] location = new double[PROBLEM_DIMENSION];
			location[0] = rastrigin_min + random.nextDouble() * (rastrigin_max - rastrigin_min);
			location[1] = rastrigin_min + random.nextDouble() * (rastrigin_max - rastrigin_min);

			double[] velocity = new double[PROBLEM_DIMENSION];
			velocity[0] = velocity[1] = 0;

			swarm.add(new Particle(new Velocity(velocity), new Location(location)));
			fitnessValueList[i] = pBest[i] = objFunction.call(swarm.get(i).getLocation().getX(),
					swarm.get(i).getLocation().getY());
			pBestLocation.add(swarm.get(i).getLocation());
		}

	}
}