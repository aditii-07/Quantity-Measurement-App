import java.util.Objects;

public class QuantityLength {

    private final double value;
    private final LengthUnit unit;
    private static final double EPSILON = 1e-6;

    public QuantityLength(double value, LengthUnit unit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
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

        double base = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(base);

        return new QuantityLength(converted, targetUnit);
    }

    public static double convert(double value, LengthUnit source, LengthUnit target) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
        if (source == null || target == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }

        double base = source.convertToBaseUnit(value);
        return target.convertFromBaseUnit(base);
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

        double base1 = q1.unit.convertToBaseUnit(q1.value);
        double base2 = q2.unit.convertToBaseUnit(q2.value);
        double sum = base1 + base2;
        double result = targetUnit.convertFromBaseUnit(sum);
        return new QuantityLength(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof QuantityLength)) return false;

        QuantityLength other = (QuantityLength) obj;

        double base1 = this.unit.convertToBaseUnit(this.value);
        double base2 = other.unit.convertToBaseUnit(other.value);
        return Math.abs(base1 - base2) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Math.round(unit.convertToBaseUnit(value) / EPSILON));
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}