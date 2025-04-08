import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Program {
    List<PersonalTask> osobniUkoly = new ArrayList<>();
    List<WorkTask> pracovniUkoly = new ArrayList<>();
    List<StudyTask> studijniUkoly = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {


        while (true) {
            System.out.println("MENU");
            System.out.println("1. Nový úkol");
            System.out.println("2. Update úkolu");
            System.out.println("3. Výpis");
            System.out.println("4. Konec");

        int volba = sc.nextInt();
        sc.nextLine();
        switch (volba) {
            case 1: {
                novyUkol();
            }

            case 2:{
                updateUkol();
            }
            case 3:{
                vypisy();
            }
            case 4: {
                System.out.println("Program ukončen.");
                return;
            }
        }
        }

        }
    public void novyUkol() {
        System.out.println("Typ úkolu(personal/work/study): ");
        String typ = sc.nextLine();

        if (typ.equals("personal")) {
            System.out.print("Popis: ");
            String popis = sc.nextLine();
            System.out.print("Max. hodin: ");
            int max = sc.nextInt();
            osobniUkoly.add(new PersonalTask(popis, max));

        } else if (typ.equals("work")) {
            System.out.print("Popis: ");
            String popis = sc.nextLine();
            System.out.print("Počet nutných hodin: ");
            int hodiny = sc.nextInt();
            sc.nextLine();
            System.out.print("Deadline: ");
            String deadline = sc.nextLine();
            System.out.print("Kč/hodina: ");
            int sazba = sc.nextInt();
            pracovniUkoly.add(new WorkTask(popis, hodiny, deadline, sazba));

        }else if (typ.equals("study")) {
            System.out.print("Předmět: ");
            String predmet = sc.nextLine();
            System.out.print("Počet hodin kolik má studium zabrat: ");
            int hodin = sc.nextInt();
            sc.nextLine();
            studijniUkoly.add(new StudyTask(predmet, hodin));
        }

        }
        public void updateUkol() {
            System.out.println("Typ úkolu: 1=Personel, 2=Work, 3=Study");
            int typ = sc.nextInt();
            sc.nextLine();

            List<? extends ITask> seznam;
            if (typ == 1) {
                seznam = osobniUkoly;
            } else if (typ == 2) {
                seznam = pracovniUkoly;
            } else {
                seznam = studijniUkoly;
            }

            for (int i = 0; i < seznam.size(); i++) {
                System.out.print(i + ": ");
                seznam.get(i).display();
            }

            System.out.println("Zadej index: ");
            int index = sc.nextInt();
            System.out.println("Hodiny: ");
            int hodin = sc.nextInt();
            System.out.println("Hotovo?(true/false): ");
            boolean d = sc.nextBoolean();
            seznam.get(index).update(hodin, d);
        }

        public void vypisy(){
        System.out.println("---VÝPISY---");
        System.out.println("1. Všechny úkoly");
        System.out.println("2. Nejdelší osobní popis");
        System.out.println("3. Počet nehotových úkolů");
        System.out.println("4. Celkový čas strávený úkoly");

        int volba = sc.nextInt();
        sc.nextLine();
        switch (volba) {
            case 1: { for(PersonalTask u: osobniUkoly)u.display();


            }
            case 2: {

            }
        }







        }







        }




























    }

