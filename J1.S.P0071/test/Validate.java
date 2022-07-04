
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validate {

    public int checkInputIntLimit(int min, int max, int c) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String a = sc.nextLine();
                if (a.equalsIgnoreCase("nope") == true && c == 1) {
                    break;
                }

                int result = Integer.parseInt(a);
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {

                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
        return -1;
    }

    public String checkDate(int c) {
        Scanner sc = new Scanner(System.in);
        String msg = "Date: ";
        while (true) {
            try {
                Date date;
                SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy");
                System.out.print(msg);
                sdf.setLenient(false);
                String a = sc.nextLine();
                if (a.equalsIgnoreCase("nope") == true && c == 1) {
                    return "no";
                } else {
                    date = sdf.parse(a);
                }
                Date now = new Date();
                if (date.after(now)) {
                    System.out.println("Enter date less than current date");
                    continue;
                }
                return sdf.format(date);

            } catch (Exception e) {
                System.out.println("\"Enter in format ddd-MM-YYYY\"");
            }
        }
    }

    public String checkInputString(String Regex) {
        Scanner sc = new Scanner(System.in);
        String text;
        do {
            text = sc.nextLine();
            if (text.matches(Regex)) {
                break;
            }
            System.out.println("nhap : ' " + Regex + " ' ");

        } while (true);
        return text;
    }

    public double checkDouble(double min, double max, int c) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String a = sc.nextLine();
                if (a.equalsIgnoreCase("nope") == true && c == 1) {
                    break;
                }
                double result = Double.parseDouble(a);
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (Exception e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
        return -1;
    }

    public double checkDoubleRegex(double min, double max, int c) {
        String Regex = "^[0-9]{1,2}\\.5([0]{0,}?)$|^[0-9]{1,2}\\.0([0]{0,}?)$|^[0-9]{1,2}$|^[0-9]{1,2}(\\.{0,1})$|^[n|N][o|O][p|P][e|E]$";
        Scanner sc = new Scanner(System.in);
        String a;
        do {
            a = sc.nextLine();
            if (a.matches(Regex)) {
                try {
                    if (a.equalsIgnoreCase("nope") == true && c == 1) {
                        return -1;
                    }
                    double result = Double.parseDouble(a);
                    if (result < min || result > max) {
                        throw new NumberFormatException();
                    }
                    return result;
                } catch (Exception e) {
                    System.err.println("Please input number in rage [" + min + ", " + max + "]");
                }
            }
            System.err.print("enter again : ");

        } while (true);
    }
}
