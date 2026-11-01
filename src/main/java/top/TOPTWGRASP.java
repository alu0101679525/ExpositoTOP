package main.java.top;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @class TOPTWGRASP
 * @brief Implementación del algoritmo metaheurístico GRASP para el problema TOPTW.
 *
 * Utiliza una fase constructiva codiciosa aleatorizada para generar múltiples
 * soluciones y se queda con la que ofrezca mejor puntuación (fitness).
 */
public class TOPTWGRASP {
    public static final double NO_EVALUATED = -1.0;
    private static final Logger logger = Logger.getLogger(TOPTWGRASP.class.getName());
    private static final Random rng = new Random();

    private TOPTWSolution solution;
    private int solutionTime;

    public TOPTWGRASP(TOPTWSolution sol){
        this.solution = sol;
        this.solutionTime = 0;
    }

    /**
     * @brief Ejecuta el procedimiento principal del algoritmo GRASP.
     * @param maxIterations Número máximo de iteraciones a ejecutar.
     * @param maxSizeRCL Tamaño máximo de la Lista Restringida de Candidatos (RCL).
     */
    public void grasp(int maxIterations, int maxSizeRCL) {
        double averageFitness = 0.0;
        double bestSolution = 0.0;
        for(int i = 0; i < maxIterations; i++) {

            this.computeGreedySolution(maxSizeRCL);

            double fitness = this.solution.evaluateFitness();
            logger.info(this.solution.getInfoSolution());
            averageFitness += fitness;
            if(bestSolution < fitness) {
                bestSolution = fitness;
            }
        }
        averageFitness = averageFitness/maxIterations;

        if(logger.isLoggable(Level.INFO)) {
            logger.info(String.format(" --> MEDIA: %f", averageFitness));
            logger.info(String.format(" --> MEJOR SOLUCION: %f", bestSolution));
        }
    }

    public int aleatorySelectionRCL(int maxTRCL) {
        return rng.nextInt(maxTRCL);
    }

    public int fuzzySelectionBestFDRCL(List< double[] > rcl) {
        double[] membershipFunction = new double[rcl.size()];
        double maxSc = this.getMaxScore();
        for(int j=0; j < rcl.size(); j++) {
            membershipFunction[j] = 1 - ((rcl.get(j)[4])/maxSc);
        }
        double minMemFunc = Double.MAX_VALUE;
        int posSelected = -1;
        for(int i = 0; i < rcl.size(); i++) {
            if(minMemFunc > membershipFunction[i]) {
                minMemFunc = membershipFunction[i];
                posSelected = i;
            }
        }
        return posSelected;
    }

    public int fuzzySelectionAlphaCutRCL(List< double[] > rcl, double alpha) {
        List< double[] > rclAlphaCut = new ArrayList<>();
        List< Integer > rclPos = new ArrayList<>();
        double[] membershipFunction = new double[rcl.size()];
        double maxSc = this.getMaxScore();
        for(int j=0; j < rcl.size(); j++) {
            membershipFunction[j] = 1 - ((rcl.get(j)[4])/maxSc);
            if(membershipFunction[j] <= alpha) {
                rclAlphaCut.add(rcl.get(j));
                rclPos.add(j);
            }
        }
        int posSelected;
        if(!rclAlphaCut.isEmpty()) {
            posSelected = rclPos.get(aleatorySelectionRCL(rclAlphaCut.size()));
        } else {
            posSelected = aleatorySelectionRCL(rcl.size());
        }
        return posSelected;
    }

    /**
     * @brief Construye una solución inicial utilizando un enfoque voraz y probabilístico.
     * @param maxSizeRCL Tamaño máximo permitido para la Lista Restringida de Candidatos.
     */
    public void computeGreedySolution(int maxSizeRCL) {
        this.solution.initSolution();

        List<List<Double>> departureTimesPerClient = new ArrayList<>();
        initializeDepartureTimes(departureTimesPerClient);

        List<Integer> customers = new ArrayList<>();
        for(int j = 1; j <= this.solution.getProblem().getPOIs(); j++) { customers.add(j); }

        List< double[] > candidates = this.comprehensiveEvaluation(customers, departureTimesPerClient);
        Collections.sort(candidates, (a, b) -> Double.compare(a[a.length-2], b[b.length-2]));

        boolean existCandidates = true;

        while(!customers.isEmpty() && existCandidates) {
            if(!candidates.isEmpty()) {
                processCandidates(maxSizeRCL, candidates, customers, departureTimesPerClient);
            } else {
                existCandidates = handleEmptyCandidates(departureTimesPerClient);
            }
            candidates.clear();
            candidates = this.comprehensiveEvaluation(customers, departureTimesPerClient);
            Collections.sort(candidates, (a, b) -> Double.compare(a[a.length-2], b[b.length-2]));
        }
    }

    private void initializeDepartureTimes(List<List<Double>> departureTimesPerClient) {
        List<Double> init = new ArrayList<>();
        int totalNodes = this.solution.getProblem().getPOIs() + this.solution.getProblem().getVehicles();
        for(int z = 0; z < totalNodes; z++) {
            init.add(0.0);
        }
        departureTimesPerClient.add(0, init);
    }

    private void processCandidates(int maxSizeRCL, List<double[]> candidates, List<Integer> customers, List<List<Double>> departureTimesPerClient) {
        List< double[] > rcl = new ArrayList<>();
        int maxTRCL = Math.min(maxSizeRCL, candidates.size());
        for(int j=0; j < maxTRCL; j++) {
            rcl.add(candidates.get(j));
        }

        int posSelected = selectCandidate(maxTRCL, rcl);
        double[] candidateSelected = rcl.get(posSelected);

        for(int j=0; j < customers.size(); j++) {
            if(customers.get(j).equals((int)candidateSelected[0])) {
                customers.remove(j);
                break;
            }
        }
        updateSolution(candidateSelected, departureTimesPerClient);
    }

    private boolean handleEmptyCandidates(List<List<Double>> departureTimesPerClient) {
        if(this.solution.getCreatedRoutes() < this.solution.getProblem().getVehicles()) {
            this.solution.addRoute();
            List<Double> initNew = new ArrayList<>();
            int totalNodes = this.solution.getProblem().getPOIs() + this.solution.getProblem().getVehicles();
            for(int z = 0; z < totalNodes; z++) {
                initNew.add(0.0);
            }
            departureTimesPerClient.add(initNew);
            return true;
        }
        return false;
    }

    private int selectCandidate(int maxTRCL, List<double[]> rcl) {
        int posSelected;
        int selection = 3;
        double alpha = 0.8;
        switch (selection) {
            case 1:  posSelected = this.aleatorySelectionRCL(maxTRCL);
                break;
            case 2:  posSelected = this.fuzzySelectionBestFDRCL(rcl);
                break;
            case 3:  posSelected = this.fuzzySelectionAlphaCutRCL(rcl, alpha);
                break;
            default: posSelected = this.aleatorySelectionRCL(maxTRCL);
                break;
        }
        return posSelected;
    }

    public void updateSolution(double[] candidateSelected, List< List< Double > > departureTimes) {
        int candidateNode = (int)candidateSelected[0];
        int routeIndex = (int)candidateSelected[1];
        int predecessorNode = (int)candidateSelected[2];

        this.solution.setPredecessor(candidateNode, predecessorNode);
        this.solution.setSuccessor(candidateNode, this.solution.getSuccessor(predecessorNode));
        this.solution.setSuccessor(predecessorNode, candidateNode);
        this.solution.setPredecessor(this.solution.getSuccessor(candidateNode), candidateNode);

        updateRouteCosts(routeIndex, predecessorNode, departureTimes);
    }

    private void updateRouteCosts(int routeIndex, int startNode, List<List<Double>> departureTimes) {
        double costInsertionPre = departureTimes.get(routeIndex).get(startNode);
        List<Double> route = departureTimes.get(routeIndex);
        int pre = startNode;
        int suc;
        int depot = this.solution.getIndexRoute(routeIndex);

        do {
            suc = this.solution.getSuccessor(pre);
            costInsertionPre += this.solution.getDistance(pre, suc);

            if(costInsertionPre < this.solution.getProblem().getReadyTime(suc)) {
                costInsertionPre = this.solution.getProblem().getReadyTime(suc);
            }
            costInsertionPre += this.solution.getProblem().getServiceTime(suc);

            if(!this.solution.isDepot(suc)) {
                route.set(suc, costInsertionPre);
            }
            pre = suc;
        } while(suc != depot);

        departureTimes.set(routeIndex, route);
    }

    public List< double[] > comprehensiveEvaluation(List<Integer> customers, List< List< Double > > departureTimes) {
        List< double[] > candidatesList = new ArrayList<>();
        double[] infoCandidate = new double[5];
        infoCandidate[0] = -1;
        infoCandidate[1] = -1;
        infoCandidate[2] = -1;
        infoCandidate[3] = Double.MAX_VALUE;
        infoCandidate[4] = -1;

        for(int candidate : customers) {
            for(int k = 0; k < this.solution.getCreatedRoutes(); k++) {
                evaluateCandidateRoute(candidate, k, departureTimes, infoCandidate);
            }

            if(infoCandidate[0]!=-1 && infoCandidate[1]!=-1 && infoCandidate[2]!=-1 && infoCandidate[3] != Double.MAX_VALUE && infoCandidate[4]!=-1) {
                double[] infoCandidate2 = new double[5];
                infoCandidate2[0] = infoCandidate[0];
                infoCandidate2[1] = infoCandidate[1];
                infoCandidate2[2] = infoCandidate[2];
                infoCandidate2[3] = infoCandidate[3];
                infoCandidate2[4] = infoCandidate[4];
                candidatesList.add(infoCandidate2);
            }
            infoCandidate[0] = -1;
            infoCandidate[1] = -1;
            infoCandidate[2] = -1;
            infoCandidate[3] = Double.MAX_VALUE;
            infoCandidate[4] = -1;
        }

        return candidatesList;
    }

    private void evaluateCandidateRoute(int candidate, int k, List< List< Double > > departureTimes, double[] infoCandidate) {
        int depot = this.solution.getIndexRoute(k);
        int pre = depot;
        int suc;

        do {
            suc = this.solution.getSuccessor(pre);
            double costInsertion = evaluateInsertionInRoute(candidate, k, pre, suc, departureTimes, depot);

            if(costInsertion != -1 && costInsertion < infoCandidate[3]) {
                infoCandidate[0] = candidate;
                infoCandidate[1] = k;
                infoCandidate[2] = pre;
                infoCandidate[3] = costInsertion;
                infoCandidate[4] = this.solution.getProblem().getScore(candidate);
            }

            pre = suc;
        } while(suc != depot);
    }

    private double evaluateInsertionInRoute(int candidate, int k, int pre, int suc, List< List< Double > > departureTimes, int depot) {
        double timesUntilPre = departureTimes.get(k).get(pre) + this.solution.getDistance(pre, candidate);
        if(timesUntilPre >= (this.solution.getProblem().getDueTime(candidate))) {
            return -1;
        }

        double costCand = Math.max(timesUntilPre, this.solution.getProblem().getReadyTime(candidate)) + this.solution.getProblem().getServiceTime(candidate);
        if(costCand > this.solution.getProblem().getMaxTimePerRoute()) { return -1; }

        double timesUntilSuc = costCand + this.solution.getDistance(candidate, suc);
        if(timesUntilSuc >= (this.solution.getProblem().getDueTime(suc))) { return -1; }

        double costSuc = Math.max(timesUntilSuc, this.solution.getProblem().getReadyTime(suc)) + this.solution.getProblem().getServiceTime(suc);
        if(costSuc > this.solution.getProblem().getMaxTimePerRoute()) { return -1; }

        double costInsertion = costSuc;
        int pre2 = suc;
        int suc2;

        if(suc != depot) {
            do {
                suc2 = this.solution.getSuccessor(pre2);
                double timesUntilSuc2 = costInsertion + this.solution.getDistance(pre2, suc2);
                if(timesUntilSuc2 >= (this.solution.getProblem().getDueTime(suc2))) { return -1; }

                costInsertion = Math.max(timesUntilSuc2, this.solution.getProblem().getReadyTime(suc2)) + this.solution.getProblem().getServiceTime(suc2);
                if(costInsertion > this.solution.getProblem().getMaxTimePerRoute()) { return -1; }
                pre2 = suc2;
            } while(suc2 != depot);
        }

        return costInsertion;
    }

    public TOPTWSolution getSolution() {
        return solution;
    }

    public void setSolution(TOPTWSolution solution) {
        this.solution = solution;
    }

    public int getSolutionTime() {
        return solutionTime;
    }

    public void setSolutionTime(int solutionTime) {
        this.solutionTime = solutionTime;
    }

    public double getMaxScore() {
        double maxSc = -1.0;
        for(int i = 0; i < this.solution.getProblem().getScore().length; i++) {
            if(this.solution.getProblem().getScore(i) > maxSc)
                maxSc = this.solution.getProblem().getScore(i);
        }
        return maxSc;
    }
}