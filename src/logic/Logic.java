package logic;

import db.MemoDB;
import entity.Memo;

import java.util.ArrayList;
import java.util.Scanner;

import static printer.Printer.*;

public class Logic {
    MemoDB memoDB = new MemoDB();
    Scanner scanner = new Scanner(System.in);

    public void scanIsNum() {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print(BLANK + RETYPE_NOT_NUM);
            scanner.nextLine();
        }
    }

    public void insertMemo() {
        System.out.println(BLANK + HEADER);
        System.out.print(BLANK + TYPE_USERNAME);
        String userName = scanner.nextLine();

        System.out.print(BLANK + TYPE_CONTENT);
        String userContent = scanner.nextLine();

        System.out.print(BLANK + TYPE_PW);

        int userPw = scanAndGetNum();

        while (userPw == -1) {
            System.out.print(BLANK + RETYPE_NOT_NUM);
            userPw = scanAndGetNum();
        }

        while ((int) (Math.log10(userPw) + 1) != 4) {
            System.out.print(BLANK + TYPE_PW_AGAIN);
            userPw = scanAndGetNum();
        }

        Memo memo = new Memo(userName, userPw, userContent);
        memoDB.insertMemo(memo);
        System.out.println(BLANK + COMPLETE_MEMO_INSERT);
    }

    public void showMemoList() {
        System.out.println(BLANK + HEADER);
        ArrayList<Memo> memos = memoDB.getAllMemo();

        if (memos.isEmpty()) {
            System.out.println(BLANK + NOMEMOS_SHOW);
        }

        for (Memo memo : memos) {
            System.out.println(BLANK + MEMO_NUM + memo.getIdx());
            System.out.println(BLANK + MEMO_AUTHOR + memo.getName());
            System.out.println(BLANK + MEMO_CONTENT + memo.getContent());
            System.out.println(BLANK + MEMO_CREATED_DATE + memo.getCreatedDate());
            System.out.println(BLANK + MEMO_MODIFIED_DATE + memo.getModifiedDate());
            System.out.println(BLANK + FOOTER);
        }

        System.out.print(BLANK + TYPE_0_BACK);
        String number = scanner.nextLine();
        if (!number.equals("0")) {
            showMemoList();
        }
    }

    public void modifyMemo() {
        if (memoDB.getAllMemo().size() == 0) {
            System.out.println(BLANK + NOMEMOS_MODIFY);
            System.out.print(BLANK + TYPE_0_BACK);
            String number = scanner.nextLine();
            if (!number.equals("0")) {
                modifyMemo();
            }
            return;
        }

        System.out.println(BLANK + HEADER);
        System.out.print(BLANK + TYPE_MEMO_NUM_MODIFY);

        int memoNum = scanAndGetNum();
        while (memoDB.getMemoNum(memoNum) == null) {
            System.out.print(BLANK + RETYPE_NOMEMO_MODIFY);
            memoNum = scanAndGetNum();
        }

        System.out.print(BLANK + TYPE_PW);
        int memoPw = scanAndGetNum();
        while (memoDB.getMemoNum(memoNum).getPw() != memoPw) {
            System.out.print(BLANK + RETYPE_INCORRECT_PW);
            memoPw = scanAndGetNum();
        }
        System.out.println(BLANK + PW_CORRECT);
        System.out.print(BLANK + TYPE_MODIFY_CONTENT);

        String memoContent = scanner.nextLine();
        memoDB.getMemoNum(memoNum).setMemoContent(memoContent);
        System.out.println(BLANK + COMPLETE_MEMO_MODIFY);
    }

    public void deleteMemo() {
        System.out.println(BLANK + HEADER);

        if (memoDB.getAllMemo().size() == 0) {
            System.out.println(BLANK + NOMEMOS_DELETE);
            System.out.print(BLANK + TYPE_0_BACK);
            String number = scanner.nextLine();
            if (!number.equals("0")) {
                deleteMemo();
            }
            return;
        }

        System.out.print(BLANK + TYPE_MEMO_NUM);

        int deleteNum = scanAndGetNum();
        while (memoDB.getMemoNum(deleteNum) == null) {
            System.out.print(BLANK + RETYPE_NOMEMO_DELETE);
            deleteNum = scanAndGetNum();
        }
        System.out.print(BLANK + TYPE_PW);
        int deletePassword = scanAndGetNum();
        while (memoDB.getMemoNum(deleteNum).getPw() != deletePassword) {
            System.out.print(BLANK + RETYPE_INCORRECT_PW);
            deletePassword = scanAndGetNum();
        }
        memoDB.deleteMemo(deleteNum);
        System.out.println(BLANK + COMPLETE_MEMO_DELETE);
    }

    private int scanAndGetNum() {
        String str = scanner.nextLine();
        try {
            int value = Integer.parseInt(str);
            return value;
        } catch (Exception e) {
            return -1;
        }
    }
}

//Ctrl + Alt + v 리턴 타입을 모를 때 사용하면 좋다
//createdUserName 에 scanner로 입력받은 값을 할당한다.
//nextInt는 enter 값을 반환하지 않기 때문에 버퍼에 남아있어 빼주어야 한다.
//그렇지 않으면 이런저런 오류가 남
//Math.log10(인자)+1 <- (숫자의 자리수를 판별해줌) 을 사용해서 4가 아니면 빠져나오지 않는다.
//인스턴스 생성
//메모리스트에 인서트 하는 부분(만들어진 매서드 사용해서)
