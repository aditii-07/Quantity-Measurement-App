public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        System.out.println(q1.convertTo(LengthUnit.INCHES));
        System.out.println(q1.add(q2));
        System.out.println(QuantityLength.add(q1, q2, LengthUnit.YARDS));
        System.out.println(q1.equals(q2));
    }
}