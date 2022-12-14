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

//Ctrl + Alt + v ?????? ????????? ?????? ??? ???????????? ??????
//createdUserName ??? scanner??? ???????????? ?????? ????????????.
//nextInt??? enter ?????? ???????????? ?????? ????????? ????????? ???????????? ???????????? ??????.
//????????? ????????? ???????????? ????????? ???
//Math.log10(??????)+1 <- (????????? ???????????? ????????????) ??? ???????????? 4??? ????????? ??????????????? ?????????.
//???????????? ??????
//?????????????????? ????????? ?????? ??????(???????????? ????????? ????????????)
