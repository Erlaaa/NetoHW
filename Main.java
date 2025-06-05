import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int income = 0;
        int expenses = 0;

        while (true) {
            System.out.println("Выберите операцию и введите её номер: ");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");

            String input = scanner.nextLine();

            if ("end".equals(input)) {
                break;
            }
            int operation = Integer.parseInt(input);

            switch (operation) {
                    case 1:
                        System.out.println("Введите сумму дохода: ");
                        int money = Integer.parseInt(scanner.nextLine());
                        income += money;
                        break;
                    case 2:
                        System.out.println("Введите сумму расхода: ");
                        int spending = Integer.parseInt(scanner.nextLine());
                        expenses += spending;
                        break;
                    case 3:
                        int taxInc = taxIncome(income);
                        int tax = taxIncomeMinusExpenses(income, expenses);

                        System.out.println("Ваш налог составит: " + taxInc + " рублей (УСН доходы)");
                        System.out.println("Налог по другой системе: " + tax + " рублей (УСН доходы минус расходы)");

                        Difference(tax, taxInc);
                        break;
                    default:
                        System.out.println("Неверный номер операции.");
                }
            }
    }

    public static int taxIncomeMinusExpenses(int income, int expenses) {
        int difference = income - expenses;
        if (difference < 0) {
            return 0;
        }
        return (difference * 15) / 100;
    }


    public static int taxIncome(int income) {
        return (income * 6) / 100;
    }


    public static void Difference(int tax, int taxInc) {
        if (taxInc < tax) {
            System.out.println("Мы советуем вам УСН доходы");
            System.out.println("Экономия: " + (tax - taxInc) + " рублей");
        } else if (taxInc > tax) {
            System.out.println("Мы советуем вам УСН доходы минус расходы");
            System.out.println("Экономия: " + (taxInc - tax) + " рублей");
        } else {
            System.out.println("Можете выбрать любую систему налогообложения");
        }
    }
}