public class Main {
    public static void main(String[] args) {
        Person person = new PersonBuilder()
                .setName("Антошка")
                .setSurname("Лопатов")
                .setAge(48)
                .setAddress("Astana")
                .build();
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(47)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .setAge(18)
                .build();
        System.out.println("У матери " + mom + " есть сын, " + son);
        System.out.println("Мужчина " + person);


        try {
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            new PersonBuilder().setAge(0).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        System.out.println(mom.hasAge());
        System.out.println(mom.hasAddress());
        mom.happyBirthday();
        System.out.println("После для рождения возраст матери составил " + mom.age);
        mom.setAddress("New York");
        System.out.println("После переезда адрес матери поменялся на " + mom.address);
        System.out.println("У сына остался город " + son.address);
    }
}

