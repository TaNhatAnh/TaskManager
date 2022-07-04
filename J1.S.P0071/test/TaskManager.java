
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TaskManager {

    private ArrayList<TaskType> list = new ArrayList<>();
    Validate check = new Validate();

    public TaskManager() {
        list.add(new TaskType(1, "Dev Program", 1, "aug-18-2015", 9.5, 17.5, "Dev", "Lead"));
        list.add(new TaskType(3, "Design Program", 1, "apr-20-2015", 10, 17, "Des", "Member"));
        list.add(new TaskType(3, "Tester", 2, "spt-23-2015", 8, 15.5, "Test", "Member"));
        UpdateId();

    }

    public void UpdateId() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setId(i + 1);
        }
    }

    public void addTask() {
        int id = list.size() + 1;

        System.out.println("-----------------------Task-----------------------");
        System.out.print("Requirement Name: ");
        String name = check.checkInputString("[A-Za-z]+");
        System.out.print("Task Type: ");
        int type = check.checkInputIntLimit(1, 4, 0);
        String date = check.checkDate(0);
        System.out.print("From: ");
        double from = check.checkDoubleRegex(8, 17, 0);
        double to;
        do {
            System.out.print("To: ");
            to = check.checkDoubleRegex(from, 17.5, 0);
            if (to < from) {
                System.out.println("Invalid time, please enter again");
            }
        } while (to <= from);
        System.out.print("Assignee: ");
        String assignee = check.checkInputString("[A-Za-z]+");
        System.out.print("Reviewer: ");
        String reviewer = check.checkInputString("[A-Za-z]+");
        list.add(new TaskType(id, name, type, date, from, to, assignee, reviewer));
        System.err.println("Added!");
//        return id;
    }

    public void update() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int flag = 0;
                System.out.print("ID: ");
                int idRm = Integer.parseInt(sc.nextLine());
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getId() == idRm) {
                        System.out.print("Requirement Name: ");
                        String name = check.checkInputString("[A-Za-z]+");
                        if (name.equalsIgnoreCase("nope") == false) {
                            list.get(i).setTaskName(name);
                        }
                        System.out.print("Task Type: ");
                        int type = check.checkInputIntLimit(1, 4, 1);
                        if (type != -1) {
                            list.get(i).setTaskType(type);
                        }
                        String date = check.checkDate(1);
                        if (date.equalsIgnoreCase("no") != true) {
                            list.get(i).setDate(date);
                        }
                        System.out.print("From: ");
                        double from = check.checkDoubleRegex(8, 17, 1);
                        if (from != -1) {
                            list.get(i).setFrom(from);
                        }
                        double to;
                        System.out.print("To: ");

                        to = check.checkDoubleRegex(list.get(i).getFrom() + 0.5, 17.5, 1);
                        if (to == -1) {
                            if(list.get(i).getTo() < list.get(i).getFrom()){
                            while (to < list.get(i).getFrom()) {
                                 System.out.println("Invalid time, please enter again");
                                to = check.checkDoubleRegex(list.get(i).getFrom() + 0.5, 17.5, 1);
                            }
                            }
                        }
                        if (to != -1) {
                            list.get(i).setTo(to);
                        }
                        System.out.print("Assignee: ");
                        String assignee = check.checkInputString("[A-Za-z]+");
                        if (assignee.equalsIgnoreCase("nope") == false) {
                            list.get(i).setAssignee(assignee);
                        }
                        System.out.print("Reviewer: ");
                        String reviewer = check.checkInputString("[A-Za-z]+");
                        if (reviewer.equalsIgnoreCase("nope") == false) {
                            list.get(i).setReviewer(reviewer);
                        }
                        System.out.println("Successfull");
                        flag = 1;

                    }

                }
                if (flag == 0) {
                    break;
                }
                break;
            } catch (Exception e) {
                System.out.println("ID does not exist");
                System.out.println("Please enter again");

            }
        }
    }

    public void deleteTask() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                int flag = 0;
                System.out.print("ID: ");
                int idRm = Integer.parseInt(sc.nextLine());
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getId() == idRm) {
                        list.remove(i);
                        flag = 1;
                        System.out.println("Successfull");
                    }
                }
                if (idRm > 0 && flag == 1) {
                    for (int i = idRm - 1; i < list.size(); i++) {
                        list.get(i).setId(list.get(i).getId() - 1);
                    }
                }
                if (flag == 0) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("ID does not exist");
                System.out.println("Please enter again");
            }
        }
    }

    public void getDataTask() {
        System.out.println("----------------------------Task-------------------------------");
        System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%-18s\n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        Collections.sort(list, (TaskType s1, TaskType s2) -> s1.getId() - (s2.getId()));
        for (TaskType o : list) {
            System.out.println(o);
        }
        System.out.println("");
    }

}
