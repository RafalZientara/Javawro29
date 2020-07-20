package pl.com.sda.rafal.zientara.apps.samples.a_creational.builder_demo;

public class Dog {

    String name;
    String breed;
    FurType furType;
    int size; //small, medium, bear
    float weight;
    float speed;
    float barkVolume;
    int bonesBuried;
    int holesDigged;
    boolean hasOwner;
    boolean canDoTricks;
    boolean isGoodDoge;

    private Dog(Builder builder) {
        this.name = builder.name;
        this.breed = builder.breed;
        this.furType = builder.furType;
        this.size = builder.size;
        this.weight = builder.weight;
        this.speed = builder.speed;
        this.barkVolume = builder.barkVolume;
        this.bonesBuried = builder.bonesBuried;
        this.holesDigged = builder.holesDigged;
        this.hasOwner = builder.hasOwner;
        this.canDoTricks = builder.canDoTricks;
        this.isGoodDoge = builder.isGoodDoge;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", furType=" + furType +
                ", size=" + size +
                ", weight=" + weight +
                ", speed=" + speed +
                ", barkVolume=" + barkVolume +
                ", bonesBuried=" + bonesBuried +
                ", holesDigged=" + holesDigged +
                ", hasOwner=" + hasOwner +
                ", canDoTricks=" + canDoTricks +
                ", isGoodDoge=" + isGoodDoge +
                '}';
    }

    static class Builder {
        private String name;
        private String breed;
        private FurType furType = FurType.LONG;
        private int size; //small, medium, bear
        private float weight;
        private float speed;
        private float barkVolume;
        private int bonesBuried;
        private int holesDigged;
        private boolean hasOwner;
        private boolean canDoTricks;
        private boolean isGoodDoge;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Builder setFurType(FurType furType) {
            this.furType = furType;
            return this;
        }

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public Builder setWeight(float weight) {
            this.weight = weight;
            return this;
        }

        public Builder setSpeed(float speed) {
            this.speed = speed;
            return this;
        }

        public Builder setBarkVolume(float barkVolume) {
            this.barkVolume = barkVolume;
            return this;
        }

        public Builder setBonesBuried(int bonesBuried) {
            this.bonesBuried = bonesBuried;
            return this;
        }

        public Builder setHolesDigged(int holesDigged) {
            this.holesDigged = holesDigged;
            return this;
        }

        public Builder setHasOwner(boolean hasOwner) {
            this.hasOwner = hasOwner;
            return this;
        }

        public Builder setCanDoTricks(boolean canDoTricks) {
            this.canDoTricks = canDoTricks;
            return this;
        }

        public Builder setGoodDoge(boolean goodDoge) {
            isGoodDoge = goodDoge;
            return this;
        }

        public Dog build() {
            return new Dog(this);
        }
    }
}
