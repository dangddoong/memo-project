import java.util.Date;

public class Memo {
    private int memoNum;
    private String userName;
    private int userPassword;
    private String memoContent;
    private Date modifiedDate;
    private static int count = 1;
    private final Date createdDate;
// static : 모든 memo 객체에서 instance들은 다 다른 값을 가지고 있다.
    // static으로 하면 공유 메모리에 올라감(모든 객체들이 공유함)
    //ex: 누가 만든 메모이던 count값은 똑같이 가진다.
    public Memo(String userName, int userPassword, String memoContent) {
        this.memoNum = count++;
        this.userName = userName;
        this.userPassword = userPassword;
        this.memoContent = memoContent;
        this.modifiedDate = new Date();
        this.createdDate = new Date();
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
    public Date getModifiedDate() {
        return modifiedDate;
    }
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setModifiedDate() {
        this.modifiedDate = new Date();
    }

    public void setMemoContent(String memoContent) {
        this.memoContent = memoContent;
    }
}
