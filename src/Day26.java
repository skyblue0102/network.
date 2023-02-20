
public class Day26 {
    private String secret = "Day26의 캡슐화된 인스턴스 변수"; //캡슐화되어 외부 클래스에서 접근 불가
    String s = "DAY26의 인스턴스 변수"; //private보다는 약하고 protected보다는 강한 접근 가짐

    class MemberClass {
        String s = "DAY26의 멤버클래스의 인스턴스 변수";

        public void show() {
            System.out.println("Inner Class");
            System.out.println(secret);  //"MemberClass안에 Secret변수가 존재하지 않아 바깥 스코"
            System.out.println(s);  //"MemberClass안에 s변수가 존재"
            System.out.println(Day26.this.s);  //"Day26의 인스턴스 변수 s의 값을 출력"
        }
        public void info(){
            System.out.println("info");
        }

        // static String s3 = "정적 멤버 필드";
        // static void show2() {}
    }

    public static void main(String[] args) {
        //MemberClass mc = new MemberClass();
        Day26 m = new Day26();
        Day26.MemberClass mc = m.new MemberClass();
        mc.info();
        System.out.println(mc.s);
        mc.show();

    }
}