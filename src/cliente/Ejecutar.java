package cliente;

import datos.ByContract;
import java.util.Date;
import persistencia.BaseDatos;

/**
 *
 * @author Nico
 */
public class Ejecutar {

    public static void main(String[] args) {
        Date fecha = new Date("12/12/2016");
        ByContract contrato
                = new ByContract(2, 1000, fecha, "A", "Fabian");
        System.out.println(contrato);
        BaseDatos bd = new BaseDatos();
        bd.almacenar("sergioarboleda",contrato);
        bd.almacenar("nacional",contrato);

    }
}
