package db;

import entity.Memo;

import java.util.ArrayList;

public class MemoDB {
    private ArrayList<Memo> memoList = new ArrayList<>();

    public void insertMemo(Memo memo) {
        memoList.add(memo);
    }

    public ArrayList<Memo> getAllMemo() {
        return memoList;
    }

    public Memo getMemoNum(int memoNum) {
        for (Memo memo : memoList) {
            if (memo.getIdx() == memoNum) {
                return memo;
            }
        }
        return null;
    }

    public void deleteMemo(int memoNum) {
        for (Memo memo : memoList) {
            if (memo.getIdx() == memoNum) {
                memoList.remove(memo);
                return;
            }
        }
    }
}


//        throw new IllegalArgumentException("검색할 번호가 없습니다.");
//        throw new IllegalArgumentException("삭제할 번호가 없습니다.");
