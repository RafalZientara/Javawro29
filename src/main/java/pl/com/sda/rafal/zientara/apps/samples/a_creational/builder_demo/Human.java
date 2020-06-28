package pl.com.sda.rafal.zientara.apps.samples.a_creational.builder_demo;

class Human {

    //wymagane parametry
    private String sex;
    private String name;
    private String age;

    //parametry opcjonalne
    private boolean programmer;
    private boolean genius;

    String getSex() {
        return sex;
    }

    String getName() {
        return name;
    }

    String getAge() {
        return age;
    }

    boolean isRich() {
        return programmer;
    }

    boolean isGenius() {
        return genius;
    }

    private Human(Builder builder) {
        this.sex = builder.sex;
        this.name = builder.name;
        this.age = builder.age;
        this.programmer = builder.programmer;
        this.genius = builder.genius;
    }

    //Klasa Buildera służąca do tworzenia obiektu
    static class Builder {

        // wymagane parametry
        private String sex;
        private String name;
        private String age;

        // parametry opcjonalne
        private boolean programmer;
        private boolean genius;

        Builder(String sex, String name, String age) {
            this.sex = sex;
            this.name = name;
            this.age = age;
        }

        Builder setGenius(boolean genius) {
            this.genius = genius;
            return this;
        }

        public Builder setProgrammer(boolean programmer) {
            this.programmer = programmer;
            return this;
        }

        public Human build() {
            return new Human(this);
        }

    }

}