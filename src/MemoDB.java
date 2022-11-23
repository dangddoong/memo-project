import java.util.ArrayList;

public class MemoDB {
    private ArrayList<Memo> memoList = new ArrayList<>();
    public void insertMemo(Memo memo){

        memoList.add(memo);
    }

    public ArrayList<Memo> getAllMemo(){

        return memoList;
    }

    public Memo getMemoNum(int memoNum){
        for (Memo memo : memoList) {
            if (memo.getMemoNum() == memoNum) {
                return memo;
            }
        }
        return null;
//        throw new IllegalArgumentException("검색할 번호가 없습니다.");
    }

    public void deleteMemo(int memoNum){
        for (Memo memo : memoList) {
            if (memo.getMemoNum() == memoNum) {
                memoList.remove(memo);
                return;
            }
        }
        throw new IllegalArgumentException("삭제할 번호가 없습니다.");
    }


}