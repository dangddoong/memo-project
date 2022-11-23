import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = -1;
        Logic logic = new Logic();
        boolean exit = false;

        while(true) {
            System.out.println("==========");
            System.out.println("메모장입니다.");
            System.out.println("1. 입력");
            System.out.println("2. 목록보기");
            System.out.println("3. 수정");
            System.out.println("4. 삭제");
            System.out.println("5. 종료");
            System.out.println("==========");
            System.out.print("원하시는 번호를 입력해주세요: ");
            input = scanner.nextInt();
            switch (input) {
                case 1:
                    logic.insertMemo();
                    break;
                case 2:
                    logic.showMemoList();
                    break;
                case 3:
                    logic.modifyMemo();
                    break;
                case 4:
                    logic.deleteMemo();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("잘못된 입력입니다.");
            }
            if(exit == true) break;
        }
    }
}
