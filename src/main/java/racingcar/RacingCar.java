package racingcar;

public class RacingCar {

    private final CarName carName;
    private final Location location;
    private final MoveForwardCondition moveForwardCondition;

    private RacingCar(CarName carName, Location location, MoveForwardCondition moveForwardCondition) {
        this.carName = carName;
        this.location = location;
        this.moveForwardCondition = moveForwardCondition;
    }

    public static RacingCar create(CarName carName, MoveForwardCondition moveForwardCondition) {
        return new RacingCar(carName, Location.init(), moveForwardCondition);
    }

    public RacingCar moveForwardByValue(int value) {
        if (this.moveForwardCondition.isForwardAllowed(value)) {
            return new RacingCar(this.carName, this.location.forward(), this.moveForwardCondition);
        }

        return this;
    }

    public void printRacingCar() {
        this.carName.printName();
        System.out.print(" : ");
        this.location.printLocation();
        System.out.println();
    }

    public int getNowLocation() {
        return this.location.now();
    }

    public boolean isSameLocation(RacingCar racingCar) {
        return this.location.isSameLocation(racingCar.getNowLocation());
    }

    public String getCarName() {
        return this.carName.getCarName();
    }
}