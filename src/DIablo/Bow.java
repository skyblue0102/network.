package DIablo;

public class Bow implements DIablo.WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("활을 사용해 원거리 딜 시작~");
    }
}
