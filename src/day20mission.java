

//# pokemon game v0.5
//        # getter setter -> property -> decorator
//        # class field
import java.util.Scanner;
class Pokemon {
    protected static int count = 0;
    protected String owner = null;
    protected String name = null;
    protected String[] skills;

    public Pokemon(String owner, String skills) {
        this.owner = owner;  //like private
        this.skills = skills.split("/");

        System.out.print("포켓몬 생성 : ");

        Pokemon.count = Pokemon.count + 1;
    }

    public String owner() {
        return owner;
    }

    public void owner(String owner) {
        this.owner = owner;
    }

    public void info() {
        System.out.printf("%s의 포켓몬이 사용 가능한 스킬", owner);

        for (int i = 0; i < this.skills.length; i++) {

            System.out.printf("\n%d : %s", i + 1, skills[i]);

//            owner = property(get_owner, set_owner)
//            for skill in self.skill:
//              System.out.printf("%s",skill);
        }
        System.out.println();
    }

    public void attack(int idx) {
        System.out.printf("%d 공격 시전!", skills[idx]);
    }
}


class Pikachu extends Pokemon {  //inheritance

    public Pikachu(String owner,String skills) {
        super(owner, skills);

        this.name = "피카츄";

        System.out.printf("%s\n",name);}

    public void attack(int idx){  //override
        System.out.printf("[삐까삐까] %s의 %s가 %s 공격 시전!\n",owner,name,skills[idx]);
    }
    }

class Ggoboogi extends Pokemon {
    public Ggoboogi(String owner, String skills) {
        super(owner, skills);
        this.name ="꼬부기";

        System.out.printf("%s\n",name);
    } //inheritance




    public void attack(int idx) {  //override
        System.out.printf("[꼬북꼬북] %s의 %s가 %s 공격 시전!\n",owner,name,skills[idx]);
    }
    public void swim(String name){
        System.out.printf("%s가 수영을 합니다", name);
    }
}

class Pairi extends Pokemon {  //inheritance

    public Pairi(String owner, String skills) {
        super(owner, skills);
        this.name = "파이리";
        System.out.printf("%s\n",name);
    }

    public void attack(int idx) { //override
        System.out.printf("[파읠파읠] %S의 %s가 %s 공격(불) 시전!\n",owner,name,skills[idx]);
    }


}




public class day20mission {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int menu = 0;
            int pokemon = 0;
            int attack_menu = 0;
            String n = null, s = null;
            System.out.printf("총 %d마리의 포켓몬이 생성되었습니다\n", Pokemon.count);
            System.out.print("1) 포켓몬 생성  2) 프로그램 종료 : ");
            menu = sc.nextInt();
            if (menu == 2) {
                System.out.println("프로그램을 종료합니다");
                break;
            }
            else if (menu == 1) {
                System.out.print("1) 피카츄  2) 꼬부기  3) 파이리 : ");
                pokemon = sc.nextInt();
                System.out.print("플레이어 이름 입력 : ");
                n = sc.next();
                System.out.print("사용 가능한 기술 입력(/로 구분하여 입력) :");
                s = sc.next();

                if (pokemon == 1) {
                    Pikachu p = new Pikachu(n, s);
                    p.info();
                    System.out.print("공격 번호 선택 : ");
                    attack_menu = sc.nextInt();
                    p.attack(attack_menu - 1);
                }
                else if (pokemon == 2) {
                    Ggoboogi p = new Ggoboogi(n, s);
                    p.info();
                    System.out.println("공격 번호 선택 : ");
                    attack_menu = sc.nextInt();
                    p.attack(attack_menu - 1);
                }
                else if (pokemon == 3) {
                    Pairi p = new Pairi(n, s);
                    p.info();
                    System.out.println("공격 번호 선택 : ");
                    attack_menu = sc.nextInt();
                    p.attack(attack_menu - 1);
                }
                else {
                    System.out.println("메뉴에서 골라 주세요");}


                }
            else{
            System.out.println("메뉴에서 골라 주세요");
        }

        }
    }
}
