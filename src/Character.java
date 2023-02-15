public abstract class Character {
    protected int hp;
    protected int mp;
    //...etc

    WeaponBehavior weapon; // Association(Agrregation)

    abstract  void info();

    public void setWeapon(WeaponBehavior weapon) {
        this.weapon = weapon;
    }
    public final void performWeapon(){
        weapon.useWeapon();
    }

}
