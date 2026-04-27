public class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid numeric value");
        }
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    public static double convert(double value, LengthUnit source, LengthUnit target) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }

        if (source == null || target == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }

        double valueInFeet = source.toFeet(value);
        return target.fromFeet(valueInFeet);
    }

    public QuantityLength convertTo(LengthUnit target) {
        double converted = convert(this.value, this.unit, target);
        return new QuantityLength(converted, target);
    }

    public static double demonstrateLengthConversion(double value, LengthUnit from, LengthUnit to) {
        return convert(value, from, to);
    }

    public static double demonstrateLengthConversion(QuantityLength q, LengthUnit to) {
        return convert(q.value, q.unit, to);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        QuantityLength other = (QuantityLength) obj;

        double thisFeet = unit.toFeet(value);
        double otherFeet = other.unit.toFeet(other.value);

        return Double.compare(thisFeet, otherFeet) == 0;
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}