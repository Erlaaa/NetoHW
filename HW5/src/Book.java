public class Book {
    public String title;
    public int releaseYear;
    public Author author;
    public int pages;

    public Book(String title, int releaseYear, Author author, int pages) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.author = author;
        this.pages = pages;
    }

    public boolean isBig() {
        return pages > 500;
    }

    public boolean matches(String word) {
        return title.contains(word) ||
                author.getName().contains(word) ||
                author.getSurname().contains(word);
    }

    public int estimatePrice() {
        double price = 3 * pages * Math.sqrt(author.getRating());
        return Math.max((int) Math.floor(price), 250);
    }

    public void printInfo() {
        System.out.println("Название: " + title);
        System.out.println("Год выпуска: " + releaseYear);
        System.out.println("Автор: " + author.getName() + " " + author.getSurname());
        System.out.println("Количество страниц: " + pages);
        System.out.println("Стоит ли считать книгу большой? " + (isBig() ? "Да" : "Нет"));
        System.out.println("Рейтинг автора: " + author.getRating());
        System.out.println("Оценочная стоимость: " + estimatePrice() + " рублей");
        System.out.println();
    }
}