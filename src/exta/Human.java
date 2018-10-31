package exta;

public class Human {
    private String id;
    private String name;
    private Integer age;
    private boolean sex;

    public static String str = "ddd";

    static {
        System.out.println("init ......");
    }

    public static void test(){

    }

    public String getId() {
        return id;
    }

    public Human setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Human setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Human setAge(Integer age) {
        this.age = age;
        return this;
    }

    public boolean isSex() {
        return sex;
    }

    public Human setSex(boolean sex) {
        this.sex = sex;
        return this;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
