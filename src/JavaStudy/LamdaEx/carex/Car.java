package JavaStudy.LamdaEx.carex;

public class Car {
    private String model;
    private boolean gasoline;

    public Car(String model, boolean gasoline) {
        this.model = model;
        this.gasoline = gasoline;
    }
    public boolean isGasoline() {
        return gasoline;
    }

    @Override
    public String toString() {
        return "Car [model=" + model + ", gasoline=" + gasoline + "]";
    }
}
