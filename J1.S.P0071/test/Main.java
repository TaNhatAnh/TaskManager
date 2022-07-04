
public class Main {

    public static int menu() {
        Validate check = new Validate();
        System.out.println("==========Task program==========");
        System.out.println("1.\tAdd Task");
        System.out.println("2.\tUpdate Task");
        System.out.println("3.\tDelete task");
        System.out.println("4.\tDisplay Task");
        System.out.println("5.\tExit");
        System.out.print("Enter your choice: ");
        int choice = check.checkInputIntLimit(1, 5, 1);
        return choice;
    }

    public static void main(String[] args) {
        TaskManager mn = new TaskManager();

        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    mn.addTask();
                    break;
                case 2:
                    mn.update();
                    break;
                case 3:
                    mn.deleteTask();
                    break;
                case 4:
                    mn.getDataTask();
                    break;
                case 5:
                    return;
            }
        }
    }

}
