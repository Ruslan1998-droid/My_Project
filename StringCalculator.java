import java.util.Scanner;

public class StringCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение (например: \"hello\" + \"world\", \"hello\" - \"lo\", \"abc\" * 3, \"hello world\" / 2):");

        String input = scanner.nextLine();

        try {
            String result = calculate(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static String calculate(String input) throws Exception {
        input = input.trim();
        String firstString = "";
        String secondValue = "";
        char operation = ' ';

        // Определяем операцию и разбиваем строку на части
        if (input.contains("+")) {
            operation = '+';
            String[] parts = input.split("\\+");
            firstString = parts[0].trim();
            secondValue = parts[1].trim();
        } else if (input.contains("-")) {
            operation = '-';
            String[] parts = input.split("-");
            firstString = parts[0].trim();
            secondValue = parts[1].trim();
        } else if (input.contains("*")) {
            operation = '*';
            String[] parts = input.split("\\*");
            firstString = parts[0].trim();
            secondValue = parts[1].trim();
        } else if (input.contains("/")) {
            operation = '/';
            String[] parts = input.split("/");
            firstString = parts[0].trim();
            secondValue = parts[1].trim();
        } else {
            throw new Exception("Неподдерживаемая операция.");
        }

        // Проверка на корректность первого аргумента
        if (!firstString.startsWith("\"") || !firstString.endsWith("\"")) {
            throw new Exception("Первый аргумент должен быть строкой в кавычках.");
        }
        firstString = firstString.substring(1, firstString.length() - 1);
        if (firstString.length() > 10) {
            throw new Exception("Длина строки не должна превышать 10 символов.");
        }

        String result = "";
        switch (operation) {
            case '+':
                if (!secondValue.startsWith("\"") || !secondValue.endsWith("\"")) {
                    throw new Exception("Второй аргумент должен быть строкой в кавычках.");
                }
                String secondString = secondValue.substring(1, secondValue.length() - 1);
                result = firstString + secondString;
                break;
            case '-':
                if (!secondValue.startsWith("\"") || !secondValue.endsWith("\"")) {
                    throw new Exception("Второй аргумент должен быть строкой в кавычках.");
                }
                secondString = secondValue.substring(1, secondValue.length() - 1);
                result = firstString.replace(secondString, "");
                if (result.isEmpty()) {
                    result = firstString; // Если вычитаемая строка не найдена, вернуть исходную строку
                }
                break;
            case '*':
                int multiplier = parseInteger(secondValue);
                result = firstString.repeat(multiplier);
                break;
            case '/':
                int divisor = parseInteger(secondValue);
                if (divisor > firstString.length()) {
                    throw new Exception("Делитель не может быть больше длины строки.");
                }
                int newLength = firstString.length() / divisor;
                result = firstString.substring(0, newLength);
                break;
            default:
                throw new Exception("Неподдерживаемая операция.");
        }

        // Ограничение длины результата
        if (result.length() > 40) {
            result = result.substring(0, 40) + "...";
        }

        return result;
    }

    private static int parseInteger(String value) throws Exception {
        value = value.trim();
        try {
            int number = Integer.parseInt(value);
            if (number < 1 || number > 10) {
                throw new Exception("Число должно быть от 1 до 10.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new Exception("Ожидалось целое число.");
        }
    }
}
