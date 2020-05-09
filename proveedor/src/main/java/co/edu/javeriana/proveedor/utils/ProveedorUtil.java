package co.edu.javeriana.proveedor.utils;

import java.math.BigDecimal;

public class ProveedorUtil {
    private static final int RANGE = 1000000;

    public static BigDecimal generarPrecio() {
        final BigDecimal max = new BigDecimal(RANGE);
        final BigDecimal randFromDouble = new BigDecimal(Math.random());
        return randFromDouble.multiply(max).setScale(2, BigDecimal.ROUND_DOWN);
    }
}
