public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength resultFeet =
                QuantityLength.add(q1, q2, LengthUnit.FEET);

        QuantityLength resultInches =
                QuantityLength.add(q1, q2, LengthUnit.INCHES);

        QuantityLength resultYards =
                QuantityLength.add(q1, q2, LengthUnit.YARDS);

        System.out.println(resultFeet);   // 2.0 FEET
        System.out.println(resultInches); // 24.0 INCHES
        System.out.println(resultYards);  // ~0.667 YARDS
    }
}