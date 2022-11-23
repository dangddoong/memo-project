import java.util.ArrayList;
import java.util.Scanner;

public class Logic {

    MemoList memoList = new MemoList();
    Scanner scanner = new Scanner(System.in);
    String input = "";

    public void insertMemo() {
        System.out.println("==========");
        System.out.print("사용자 명을 입력해주세요: ");
        String s1 = scanner.nextLine();
        System.out.print("메모 내용을 입력해주세요: ");
        String s2 = scanner.nextLine();
        System.out.print("비밀번호를 입력해주세요(숫자 네자리): ");
        String s3 = scanner.nextLine();
        System.out.println("System: 정상적으로 메모가 저장되었습니다.");
    }

    public void showMemoList() {
        System.out.println("==========");
        System.out.println("==========");
        System.out.println("메모 번호: " );
        System.out.println("메모 글쓴이: ");
        System.out.println("메모 내용: ");
        System.out.println("메모 작성일: ");
        System.out.println("메모 수정일: ");
        System.out.println("==========");
        System.out.print("뒤로 가기를 원하시면 0을 입력해주세요: ");
        String s1 = scanner.nextLine();
    }

    public void modifyMemo() {

        System.out.println("==========");
        System.out.print("수정을 원하는 메모 번호를 입력해주세요: ");
        String s1 = scanner.nextLine();
        System.out.println("메모 번호에 맞는 메모가 존재하지 않습니다. ");
        System.out.print("메모 비밀 번호를 입력해주세요: ");
        String s2 = scanner.nextLine();
        System.out.println("비밀번호가 일치하지 않습니다.");
        System.out.print("수정된 내용을 입력해주세요: ");
        String s3 = scanner.nextLine();
        System.out.println("메모이 정상적으로 수정되었습니다.");
    }

    public void deleteMemo() {
        System.out.println("==========");
        System.out.print("삭제를 원하는 메모 번호를 입력해주세요: ");
        String s1 = scanner.nextLine();
        System.out.println("메모 번호에 맞는 메모이 존재하지 않습니다.");
        System.out.print("메모 비밀번호를 입력해주세요: ");
        String s2 = scanner.nextLine();
        System.out.println("메모가 삭제되었습니다.");
        System.out.println("비밀번호가 일치하지 않습니다.");
    }
}
