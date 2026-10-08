public class ProcesadorGrafico extends OperacionGrafica {
    
    public ProcesadorGrafico(int num1, int num2) {
        super(num1, num2);
    }

    public String ejecutar(String operador) {
        try {
            int resultado;
            if (operador.equals("+")) {
                resultado = num1 + num2;
                return "Resultado: " + resultado;
            } else if (operador.equals("-")) {
                resultado = num1 - num2;
                return "Resultado: " + resultado;
            } else if (operador.equals("*")) {
                resultado = num1 * num2;
                return "Resultado: " + resultado;
            } else if (operador.equals("/")) {
                resultado = num1 / num2; // Lanza excepción si num2 es 0
                return "Resultado: " + resultado;
            } else {
                return "Error: Operador inválido.";
            }
        } catch (ArithmeticException e) {
            return "Error: No se puede dividir entre cero.";
        }
    }
}
