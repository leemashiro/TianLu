//import com.alibaba.fastjson.JSON;
//
//public class test  {
//    public static void main(String[] args) {
//        Person person = new Person("zhangsan",true,3,180);
//        String json = JSON.toJSONString(person);
//        System.out.println(json);
//    }
//    static class Person{
//        private String name;
//        private boolean sex;
//        private int age;
//        private int weight;
//        public Person(String name,boolean sex, int age,int weight) {
//            super();
//            this.name = name;
//            this.sex = sex;
//            this.age = age;
//            this.weight = weight;
//        }
//        public Person() {
//            super();
//        }
//        public String getName() {
//            return name;
//        }
//        public void setName(String name) {
//            this.name = name;
//        }
//        public int getAge() {
//            return age;
//        }
//        public void setAge(int age) {
//            this.age = age;
//        }
//
//        public int getWeight() {
//            return weight;
//        }
//        public void setWeight(int weight) {
//            this.weight = weight;
//        }
//        public boolean isSex() {
//            return sex;
//        }
//        public void setSex(boolean sex) {
//            this.sex = sex;
//        }
//        @Override
//        public String toString() {
//            return "Person [name=" + name + "sex = "+sex+", age=" + age + "]";
//        }
//    }
//}
