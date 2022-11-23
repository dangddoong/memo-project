import java.util.ArrayList;

public class MemoList {
    private ArrayList<Memo> memoList = new ArrayList<>();
    public void insertMemo(Memo memo){

        memoList.add(memo);
    }
    public ArrayList<Memo> getAllMemo(){

        return memoList;
    }

    public Memo getMemo(int memoNum){
        for (Memo memo : memoList) {
            if (memo.getMemoNum() == memoNum) {
                return memo;
            }
        }
        throw new IllegalArgumentException("검색할 번호가 없습니다.");
    }

    public void deleteMemo(int memoNum){
        for (Memo memo : memoList) {
            if (memo.getMemoNum() == memoNum) {
                memoList.remove(memo);
            }
        }
        throw new IllegalArgumentException("삭제할 번호가 없습니다.");
    }

}