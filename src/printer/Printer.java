package printer;

public class Printer {
    public static final String BLANK = "                                                                                   ";
    public static final String CLEAR = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";

    public static final String HEADER = "=================*조미김 메모장*=================";
    public static final String FOOTER = "================================================";

    public static final String LIST1 = "1. 메모 입력";
    public static final String LIST2 = "2. 메모 목록 조회";
    public static final String LIST3 = "3. 메모 수정";
    public static final String LIST4 = "4. 메모 삭제";
    public static final String LIST5 = "5. 프로그램 종료";

    public static final String TYPE_NUMBER = "원하시는 번호를 입력해주세요: ";
    public static final String TYPE_USERNAME = "사용자 명을 입력해주세요 : ";
    public static final String TYPE_CONTENT = "메모 내용을 입력해주세요 : ";
    public static final String TYPE_PW = "비밀번호를 입력해주세요(숫자 네자리) : ";
    public static final String TYPE_PW_AGAIN = "비밀번호를 다시 입력해주세요(숫자 네자리) : ";
    public static final String TYPE_0_BACK = "뒤로 가기를 원하시면 0을 입력해주세요: ";
    public static final String TYPE_MEMO_NUM_MODIFY = "수정을 원하는 메모 번호를 입력해주세요 : ";
    public static final String TYPE_MODIFY_CONTENT = "수정된 내용을 입력해주세요 : ";
    public static final String TYPE_MEMO_NUM = "삭제를 원하는 메모 번호를 입력해주세요: ";

    public static final String RETYPE_NOMEMO_MODIFY = "메모 번호에 맞는 메모가 존재하지 않습니다. \n" + BLANK + "수정을 원하는 메모 번호를 입력해주세요: ";
    public static final String RETYPE_NOMEMO_DELETE = "메모 번호에 맞는 메모가 존재하지 않습니다. \n" + BLANK + " 삭제를 원하는 메모 번호를 입력해주세요: ";
    public static final String RETYPE_INCORRECT_PW = "비밀번호가 일치하지 않습니다. \n " + BLANK + " 다시 입력해주세요 : ";
    public static final String RETYPE_NOT_NUM = "에러! 숫자가 아닙니다. \n" + BLANK + "비밀번호를 입력해주세요(숫자 네자리) : ";

    public static final String NOMEMOS_DELETE = "삭제할 메모가 없습니다.";
    public static final String NOMEMOS_MODIFY = "수정할 메모가 없습니다.";
    public static final String NOMEMOS_SHOW = "메모가 하나도 없습니다.";
    public static final String PW_CORRECT = "비밀번호가 일치합니다.";
    public static final String COMPLETE_MEMO_INSERT = "메모가 정상적으로 생성되었습니다.";
    public static final String COMPLETE_MEMO_DELETE = "메모가 정상적으로 삭제되었습니다.";
    public static final String COMPLETE_MEMO_MODIFY = "메모가 정상적으로 수정되었습니다.";
    public static final String MEMO_NUM = "메모 번호 : ";
    public static final String MEMO_AUTHOR = "메모 글쓴이 : ";
    public static final String MEMO_CONTENT = "메모 내용 : ";
    public static final String MEMO_CREATED_DATE = "메모 생성 일자 : ";
    public static final String MEMO_MODIFIED_DATE = "메모 변경 일자 : ";
    public static final String WRONG_NUM = "잘못된 숫자 입력입니다.";

    public static void clearCmd() {
        System.out.println(CLEAR);
    }
}
