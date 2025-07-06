import java.util.Scanner;

public class Main
{
    public static class Subjects
    {
        int credit;
        String name,grade, id;
        double gpoint;

        Subjects(int credit, String name, String grade, String number, double gpoint)
        {
            this.name = name;
            this.credit = credit;
            this.grade = grade;
            this.id = number;
            this.gpoint = gpoint;
        }

        static double grading(String grade)
        {
            double gp;
            switch (grade)
            {
                case ("A+"):
                case ("A"):
                gp = 4;
                break;

                case ("A-"):
                gp = 3.7;
                break;

                case ("B+"):
                gp = 3.3;
                break;

                case ("B"):
                gp = 3;
                break;

                case ("B-"):
                gp = 2.7;
                break;

                case ("C+"):
                gp = 2.3;
                break;

                case ("C"):
                gp = 2;
                break;

                case ("C-"):
                gp = 1.7;
                break;

                case ("D+"):
                gp = 1.3;
                break;

                case ("D"):
                gp = 1;
                break;

                default:
                gp = 0;
                break;
            }
        return gp;
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int count, credit;
        String name, number, grade;
        double gradepoint,totalcredits = 0, totalpoints = 0;
        double gpa;
        System.out.println("This will help you to caltulate your GPA. Add details correctly\n");

        System.out.print("Enter your subject count: ");
        count = scanner.nextInt();
        scanner.nextLine();

        Subjects[] subjects = new Subjects[count];

        for(int i=0; i<count; i++)
        {
            System.out.println("Subject "+(i+1));
            System.out.print("Enter subject ID: ");
            number = scanner.nextLine();

            System.out.print("Enter subject name: ");
            name = scanner.nextLine();

            System.out.print("Enter its credit amount: ");
            credit = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Its Grade in Capital: ");
            grade = scanner.nextLine();

            gradepoint =  Subjects.grading(grade)*credit;
            subjects[i] = new Subjects(credit, name, grade, number, gradepoint);
            System.out.print("\n");
        }
        System.out.println("\nThis is your Result Sheet\n");
        for (int x = 0; x<count; x++)
        {
            System.out.printf("%s\t%25s\t%d credits\t%s\tGrade points= %.2f\n", subjects[x].id, subjects[x].name, subjects[x].credit, subjects[x].grade, subjects[x].gpoint);
            totalcredits += subjects[x].credit;
            totalpoints += subjects[x].gpoint;
        }
        System.out.println("\n\nYou have Total "+totalpoints+" Grade points from "+totalcredits+" Credits:");
        gpa = (totalpoints/totalcredits);
        System.out.printf("Your GPA is : %.2f", gpa);

    }
}