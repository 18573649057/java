public class stu implements stu_interface {
    @Override
    public void eat(String name) {
        System.out.println("吃"+ name);
    }

    @Override
    public void study() {
        System.out.println("在家自习");
    }
}
