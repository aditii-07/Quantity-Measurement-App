import java.util.Objects;
public class QuantityLength {

    private final double value;
    private final LengthUnit unit;
    private static final double EPSILON = 1e-6;

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

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    public QuantityLength convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double base = toBaseUnit(this.value, this.unit);
        double converted = fromBaseUnit(base, targetUnit);

        return new QuantityLength(converted, targetUnit);
    }

    public static double convert(double value, LengthUnit source, LengthUnit target) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
        if (source == null || target == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }

        double base = toBaseUnit(value, source);
        return fromBaseUnit(base, target);
    }

    private static double toBaseUnit(double value, LengthUnit unit) {
        return value * unit.getConversionFactor();
    }

    private static double fromBaseUnit(double baseValue, LengthUnit unit) {
        return baseValue / unit.getConversionFactor();
    }

    public QuantityLength add(QuantityLength other) {
        return add(this, other, this.unit);
    }

    public static QuantityLength add(QuantityLength q1, QuantityLength q2, LengthUnit targetUnit) {

        if (q1 == null || q2 == null) {
            throw new IllegalArgumentException("Operands cannot be null");
        }
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double base1 = toBaseUnit(q1.value, q1.unit);
        double base2 = toBaseUnit(q2.value, q2.unit);
        double sumBase = base1 + base2;
        double result = fromBaseUnit(sumBase, targetUnit);
        return new QuantityLength(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof QuantityLength)) return false;

        QuantityLength other = (QuantityLength) obj;

        double base1 = toBaseUnit(this.value, this.unit);
        double base2 = toBaseUnit(other.value, other.unit);

        return Math.abs(base1 - base2) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                Math.round(toBaseUnit(value, unit) / EPSILON)
        );
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}