import java.util.ArrayList;
import java.util.Scanner;

public class Logic {
    MemoList memoList = new MemoList();
    Scanner scanner = new Scanner(System.in);

    public void scanIsNum(){
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.err.print("에러! 숫자가 아닙니다. \n다시 입력해주세요 : ");
        }
        scanner.nextLine();
    }

    public void insertMemo() {
        System.out.println("==========");
        System.out.print("사용자 명을 입력해주세요 : ");
        String createdUserName = scanner.nextLine();
        //createdUserName 에 scanner로 입력받은 값을 할당한다.

        System.out.print("메모 내용을 입력해주세요 : ");
        String createdMemoContent = scanner.nextLine();

        System.out.print("비밀번호를 입력해주세요(숫자 네자리) : ");
        scanIsNum();
        int createdUserPassword = scanner.nextInt();
        while ((int) (Math.log10(createdUserPassword) + 1) != 4) {
            System.err.print ("4자리 숫자가 아닙니다. \n비밀번호를 다시 입력해주세요 : ");
            scanIsNum();
            createdUserPassword = scanner.nextInt();
        }
        //nextInt는 enter 값을 반환하지 않기 때문에 버퍼에 남아있어 빼주어야 한다.
        //그렇지 않으면 이런저런 오류가 남
        // Math.log10(인자)+1 <- (숫자의 자리수를 판별해줌) 을 사용해서 4가 아니면 빠져나오지 않는다.

        Memo memo = new Memo(createdUserName, createdUserPassword, createdMemoContent);
        //인스턴스 생성

        memoList.insertMemo(memo);
        //메모리스트에 인서트 하는 부분(만들어진 매서드 사용해서)
        System.out.println("System: 정상적으로 메모가 저장되었습니다.");
    }

    public void showMemoList() {
        //Ctrl + Alt + v 리턴 타입을 모를 때 사용하면 좋다
        ArrayList<Memo> allMemo = memoList.getAllMemo();
        for (Memo memo : allMemo) {
            System.out.println("==========");
            System.out.println("==========");
            System.out.println("메모 번호 : " + memo.getMemoNum());
            System.out.println("메모 글쓴이 : " + memo.getUserName());
            System.out.println("메모 내용 : " + memo.getMemoContent());
            System.out.println("메모 작성일 : " + memo.getCreatedDate());
            System.out.println("메모 수정일 : " + memo.getModifiedDate());
            System.out.println("==========");
        }
        System.out.print("뒤로 가기를 원하시면 0을 입력해주세요: ");
        String number = scanner.nextLine();
        if (!number.equals("0")) {
            showMemoList();
        }
    }

    public void modifyMemo() {
        System.out.println("==========");
        System.out.print("수정을 원하는 메모 번호를 입력해주세요 : ");
        scanIsNum();
        int modifyMemoNum = scanner.nextInt();
        while (memoList.getMemoNum(modifyMemoNum) == null) {
            System.err.print("메모 번호에 맞는 메모가 존재하지 않습니다. \n수정을 원하는 메모 번호를 입력해주세요: ");
            scanIsNum();
            modifyMemoNum = scanner.nextInt();
        }
        scanner.nextLine();
        System.out.print("메모 비밀 번호를 입력해주세요 : ");
        scanIsNum();
        int modifyMemoPassword = scanner.nextInt();

        while (memoList.getMemoNum(modifyMemoNum).getUserPassword() != modifyMemoPassword) {
            System.err.print("비밀번호가 일치하지 않습니다. \n다시 입력해주세요 : ");
            scanIsNum();
            modifyMemoPassword = scanner.nextInt();
        }
        scanner.nextLine();
        System.out.println("비밀번호가 일치합니다.");
        System.out.print("수정된 내용을 입력해주세요 : ");

        String modifyMemoContent = scanner.nextLine();

        memoList.getMemoNum(modifyMemoNum).setMemoContent(modifyMemoContent);
        memoList.getMemoNum(modifyMemoNum).setModifiedDate();
        System.out.println("System: 메모가 정상적으로 수정되었습니다.");
    }

    public void deleteMemo() {
        if (memoList.getAllMemo().isEmpty()){
            System.err.println("삭제할 메모가 없습니다.");
            return;
        }
        System.out.println("==========");
        System.out.print("삭제를 원하는 메모 번호를 입력해주세요: ");

        scanIsNum();
        int deleteNum = scanner.nextInt();
        while (memoList.getMemoNum(deleteNum) == null) {
            System.err.print("메모 번호에 맞는 메모가 존재하지 않습니다. \n삭제를 원하는 메모 번호를 입력해주세요: ");
            scanIsNum();
            deleteNum = scanner.nextInt();
        }
        System.out.print("메모 비밀번호를 입력해주세요: ");
        int deletePassword = scanner.nextInt();
        while (memoList.getMemoNum(deleteNum).getUserPassword() != deletePassword) {
            System.err.print("비밀번호가 일치하지 않습니다. \n다시 입력해주세요 : ");
            scanIsNum();
            deletePassword = scanner.nextInt();
        }
        memoList.deleteMemo(deleteNum);
        System.out.println("System: 메모가 삭제되었습니다.");
    }
}
