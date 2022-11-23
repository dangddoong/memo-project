import logic.Logic;

import java.util.Scanner;

import static printer.Printer.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logic logic = new Logic();

        while (true) {
            System.out.println(BLANK + HEADER);
            System.out.println(BLANK + LIST1);
            System.out.println(BLANK + LIST2);
            System.out.println(BLANK + LIST3);
            System.out.println(BLANK + LIST4);
            System.out.println(BLANK + LIST5);
            System.out.println(BLANK + FOOTER);
            System.out.print(BLANK + TYPE_NUMBER);
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    logic.insertMemo();
                    break;
                case "2":
                    logic.showMemoList();
                    break;
                case "3":
                    logic.modifyMemo();
                    break;
                case "4":
                    logic.deleteMemo();
                    break;
                case "5":
                    System.exit(0);
                default:
                    System.out.println(WRONG_NUM);
            }
        }
    }
}
