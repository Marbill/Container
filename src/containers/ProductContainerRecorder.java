package containers;

/* @author marbi */
public class ProductContainerRecorder extends ProductContainer {

    private ContainerHistory chistory;

    public ProductContainerRecorder(String productName, double capacity, double initialVolume) {
        super(productName, capacity);
        this.chistory = new ContainerHistory();
        this.addToTheContainer(initialVolume);
    }

    public String history() {
        return this.chistory.toString();
    }

    public void addToTheContainer(double amount) {
        super.addToTheContainer(amount);
        this.chistory.add(super.getVolume());
    }

    public double takeFromTheContainer(double amount) {

        double firstVol = this.getVolume();
        super.takeFromTheContainer(amount);
        this.chistory.add(super.getVolume());

        return firstVol - this.getVolume();

    }

    public void printAnalysis() {
        System.out.println("Product: " + this.getName());
        System.out.println("History: " + this.history());
        System.out.println("Greatest product amount: " + this.chistory.maxValue());
        System.out.println("Smallest product amount: " + this.chistory.minValue());
        System.out.println("Average: " + this.chistory.average());
        System.out.println("Greatest change: " + this.chistory.greatestFluctuation());
        System.out.println("Variance: " + this.chistory.variance());
    }

}
