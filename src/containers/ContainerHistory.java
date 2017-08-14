package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* @author marbi */
public class ContainerHistory {

    private List<Double> history;

    public ContainerHistory() {
        this.history = new ArrayList<Double>();
    }

    public void add(double situation) {
        this.history.add(situation);
    }

    public void reset() {
        this.history.clear();
    }

    @Override
    public String toString() {
        return this.history.toString();
    }

    public double maxValue() {
        return Collections.max(this.history);
    }

    public double minValue() {
        return Collections.min(this.history);
    }

    public double average() {
        double total = 0.0;

        for (Double h : history) {
            total += h;
        }

        return total / this.history.size();
    }

    public double greatestFluctuation() {
        List<Double> fluctuations = new ArrayList<Double>();

        if (this.history.isEmpty() || this.history.size() < 2) {
            return 0;
        }

        for (int i = 0; i < this.history.size() - 1; i++) {
            fluctuations.add(Math.abs(this.history.get(i + 1) - this.history.get(i)));
        }

        return Collections.max(fluctuations);
    }

    public double variance() {
        double total = 0.0;

        for (Double h : history) {
            total += (Math.pow(h - this.average(), 2));
        }

        return total / (this.history.size() - 1);
    }
}
