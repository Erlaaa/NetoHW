public class Main {
    public static void main(String[] args) {


        Author king = new Author("Стивен", "Кинг", 9);
        Author omear = new Author("Майк", "Омер", 8);
        Author doyle = new Author("Артур Конан", "Дойль", 10);


        Book book1 = new Book("Оно", 1986, king, 1138);
        Book book2 = new Book("Зелёная миля", 1996, king, 384);
        Book book3 = new Book("Убийство в Восточном экспрессе", 1934, doyle, 256);
        Book book4 = new Book("Призрачный час", 2017, omear, 410);
        Book book5 = new Book("Шерлок Холмс. Собака Баскервилей", 1902, doyle, 184);
        Book book6 = new Book("Темная башня", 1982, king, 400);


        book1.printInfo();
        book2.printInfo();
        book3.printInfo();
        book4.printInfo();
        book5.printInfo();
        book6.printInfo();


        System.out.println("Поиск по слову \"Холмс\":");
        if (book5.matches("Холмс")) {
            System.out.println("Книга \"" + book5.title + "\" совпадает.");
        }

        System.out.println("\nПоиск по слову \"Кинг\":");
        if (book1.matches("Кинг")) {
            System.out.println("Книга \"" + book1.title + "\" совпадает.");
        }

        System.out.println("\nПоиск по слову \"детектив\":");
        if (book3.matches("детектив") || book5.matches("детектив")) {
            System.out.println("Есть совпадения.");
        } else {
            System.out.println("Совпадений нет.");
        }
    }
}