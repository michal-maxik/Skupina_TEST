import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Program {
    static List<PersonalTask> osobniUkoly = new ArrayList<>();
    static List<WorkTask> pracovniUkoly = new ArrayList<>();
    static List<StudyTask> studijniUkoly = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("--- MENU ---");
            System.out.println("1. Nový úkol");
            System.out.println("2. Update úkolu");
            System.out.println("3. Výpisy");
            System.out.println("4. Konec");

            int volba = sc.nextInt();
            sc.nextLine();

            switch (volba) {
                case 1 -> novyUkol();
                case 2 -> updateUkol();
                case 3 -> vypisy();
                case 4 -> {
                    System.out.println("Program ukončen.");
                    return;
                }
            }
        }
    }

    static void novyUkol() {
        System.out.print("Typ úkolu (personal/work/study): ");
        String typ = sc.nextLine();

        if (typ.equals("personal")) {
            System.out.print("Popis: ");
            String popis = sc.nextLine();
            System.out.print("Max. hodiny: ");
            int max = sc.nextInt();
            osobniUkoly.add(new PersonalTask(popis, max));
        } else if (typ.equals("work")) {
            System.out.print("Popis: ");
            String popis = sc.nextLine();
            System.out.print("Počet hodin nutných: ");
            int hodin = sc.nextInt();
            sc.nextLine();
            System.out.print("Deadline: ");
            String deadline = sc.nextLine();
            System.out.print("Kč/hodina: ");
            int sazba = sc.nextInt();
            pracovniUkoly.add(new WorkTask(popis, hodin, deadline, sazba));
        } else if (typ.equals("study")) {
            System.out.print("Předmět: ");
            String predmet = sc.nextLine();
            System.out.print("Kolik má zabrat hodin: ");
            int hodiny = sc.nextInt();
            studijniUkoly.add(new StudyTask(predmet, hodiny));
        }
    }

    static void updateUkol() {
        System.out.println("Typ úkolu: 1=Personal, 2=Work, 3=Study");
        int typ = sc.nextInt();
        sc.nextLine(); // Čistíme buffer po zadání čísla

        List<? extends ITask> seznam;
        if (typ == 1) seznam = osobniUkoly;
        else if (typ == 2) seznam = pracovniUkoly;
        else seznam = studijniUkoly;

        for (int i = 0; i < seznam.size(); i++) {
            System.out.print(i + ": ");
            seznam.get(i).display();
        }

        System.out.print("Zadej index: ");
        int index = sc.nextInt();
        sc.nextLine(); // Čistíme buffer po zadání čísla

        System.out.print("Hodiny: ");
        int h = sc.nextInt();
        sc.nextLine(); // Čistíme buffer po zadání čísla

        System.out.print("Hotovo? (true/false): ");
        boolean d = sc.nextBoolean();
        sc.nextLine(); // Čistíme buffer po zadání boolean hodnoty

        seznam.get(index).update(h, d);
    }

    static void vypisy() {
        System.out.println("--- VÝPISY ---");
        System.out.println("1. Všechny úkoly");
        System.out.println("2. Nejdelší osobní popis");
        System.out.println("3. Počet nehotových úkolů");
        System.out.println("4. Celkový čas strávený");

        int volba = sc.nextInt();
        sc.nextLine();

        switch (volba) {
            case 1 -> {
                for (PersonalTask u : osobniUkoly) u.display();
                for (WorkTask u : pracovniUkoly) u.display();
                for (StudyTask u : studijniUkoly) u.display();
            }
            case 2 -> {
                String nej = "";
                for (PersonalTask u : osobniUkoly)
                    if (u.getPopis().length() > nej.length()) nej = u.getPopis();
                System.out.println("Nejdelší popis: " + nej);
            }
            case 3 -> {
                int count = 0;
                for (PersonalTask u : osobniUkoly) if (!u.isDone()) count++;
                for (WorkTask u : pracovniUkoly) if (!u.isDone()) count++;
                for (StudyTask u : studijniUkoly) if (!u.isDone()) count++;
                System.out.println("Nehotových: " + count);
            }
            case 4 -> {
                int suma = 0;
                for (PersonalTask u : osobniUkoly) suma += u.getOdpracovano();
                for (WorkTask u : pracovniUkoly) suma += u.getOdpracovano();
                for (StudyTask u : studijniUkoly) suma += u.getOdpracovano();
                System.out.println("Celkem odpracováno: " + suma + " hodin");
            }
        }
    }
}









