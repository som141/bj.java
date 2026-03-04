package Lamda;

public class BuilderPattern {
    private int age;
    private String name;
    private String email;
    public static Builder BuilderPattern() {
    return new Builder();
    }

    public static void main(String[] args) {
        BuilderPattern bp =  BuilderPattern.Builder();
        Builder b=bp.BuilderPattern();
        b.name("영주");
        b.email("dssd");
        System.out.println(b.age+" "+b.name+" "+b.email);
    }
    public static class Builder {
        int age;
        String name;
        String email;
        public Builder age(int age) {
            this.age = age;
            return this;
        }
        public Builder name(String name) {
            this.name=name;
            return this;

        }
        public Builder email(String email) {
            this.email=email;
            return this;
        }

    }
}
