import java.util.Date;

public class Memo {
    private int memoNum;
    private String userName;
    private int userPassword;
    private String memoContent;
    private Date date;
    private static int count = 1;
// static : 모든 memo 객체에서 instance들은 다 다른 값을 가지고 있다.
    // static으로 하면 공유 메모리에 올라감(모든 객체들이 공유함)
    //ex: 누가 만든 메모이던 count값은 똑같이 가진다.
    public Memo(String userName, int userPassword, String memoContent) {
        this.memoNum = count++;
        this.userName = userName;
        this.userPassword = userPassword;
        this.memoContent = memoContent;
        this.date = new Date();
    }
    public int getMemoNum(){
        return memoNum;
    }
    public String getUserName(){
        return userName;
    }
    //입력받음
    public int getUserPassword() {
        return userPassword;
    }
    //입력받음
    public String getMemoContent() {
        return memoContent;
    }
    //입력받음
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
        //수정 담당하는 사람이 set할때마다 바꿀 수 있도록~
    }
}
