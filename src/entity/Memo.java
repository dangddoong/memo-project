package entity;

import java.util.Date;

public class Memo {
    private int idx;
    private String name;
    private int pw;
    private String content;
    private Date modifiedDate;
    private Date createdDate;
    private static int count = 1;

    public Memo(String name, int pw, String content) {
        this.idx = count++;
        this.name = name;
        this.pw = pw;
        this.content = content;
        this.modifiedDate = new Date();
        this.createdDate = new Date();
    }

    public int getIdx() {
        return idx;
    }

    public String getName() {
        return name;
    }

    public int getPw() {
        return pw;
    }

    public String getContent() {
        return content;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setMemoContent(String memoContent) {
        this.content = memoContent;
        this.modifiedDate = new Date();
    }
}

// static : 모든 memo 객체에서 instance들은 다 다른 값을 가지고 있다.
// static으로 하면 공유 메모리에 올라감(모든 객체들이 공유함)
//ex: 누가 만든 메모이던 count값은 똑같이 가진다.
//입력받음
//입력받음
//입력받음
