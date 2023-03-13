public class Main {
    public static void main(String[] args) {

        Doctor doctor = new Doctor("Facundo Arambillet","Cardiologia");
        System.out.println((doctor.getId()));
        Doctor doctor_2 = new Doctor("Clemente Cifuentes","Neurologia");
        System.out.println((doctor_2.getId()));


        System.out.println((doctor));
        System.out.println((doctor_2));
        doctor_2 = doctor;
        System.out.println((doctor));
        System.out.println((doctor_2));

        Patient patient = new Patient("Facundo","test@test.com","Juan elicagaray",
                "123456","14/11/1998",1.78,71,"0+");

        System.out.println((patient.getName()));
    }
}
