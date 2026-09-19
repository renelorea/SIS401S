public class practica2 {

public class Practica1 {
    public static void main(String[] args) {
        Persona persona = new Persona ();

        persona.getNombre("Daniela");
        persona.getEdad(28);
        persona.getColor("Morena");
        persona.getPeso(62);
        persona.getEstatura(1.65);

        System.out.println("Nombre: " + persona.getNombre("Daniela"));
        System.out.println("Edad: " + persona.getEdad(28));
        System.out.println("Color: " + persona.getColor("Morena"));
        System.out.println("Peso: " + persona.getPeso(62));
        System.out.println("Estatura: " + persona.getEstatura(1.65));

    }
}
