import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Створити порожнє ігрове поле
        char[] cells = "         ".toCharArray();

        // Вивести порожнє ігрове поле
        printGameBoard(cells);

        // Почати гру
        playGame(cells);
    }

    public static void playGame(char[] cells) {
        // Цикл гри
        while (true) {
            // Гравець X робить хід
            makeMove(cells, 'X');

            // Вивести оновлене ігрове поле
            printGameBoard(cells);

            // Перевірка на перемогу або нічию
            if (checkGameStatus(cells)) {
                break;
            }

            // Гравець O робить хід
            makeMove(cells, 'O');

            // Вивести оновлене ігрове поле
            printGameBoard(cells);

            // Перевірка на перемогу або нічию
            if (checkGameStatus(cells)) {
                break;
            }
        }
    }

    public static void makeMove(char[] cells, char playerSymbol) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Запитати користувача про хід
            System.out.print("Enter the coordinates: ");
            String coordinatesInput = scanner.nextLine();

            try {
                // Розбити введені координати
                String[] coordinates = coordinatesInput.split(" ");
                int row = Integer.parseInt(coordinates[0]) - 1;
                int col = Integer.parseInt(coordinates[1]) - 1;

                // Перевірити коректність координат
                if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                    int index = row * 3 + col;
                    if (cells[index] == ' ') {
                        // Встановити символ гравця на обраній клітинці
                        cells[index] = playerSymbol;
                        break;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("You should enter numbers!");
            }
        }
    }

    public static void printGameBoard(char[] cells) {
        // Виведення ігрового поля
        System.out.println("---------");

        for (int i = 0; i < cells.length; i++) {
            System.out.print("| ");
            System.out.print(cells[i] + " ");
            if ((i + 1) % 3 == 0) {
                System.out.println("|");
            }
        }

        System.out.println("---------");
    }

    public static boolean checkGameStatus(char[] cells) {
        // Перевірка на перемогу або нічию

        if (checkWinner(cells, 'X')) {
            System.out.println("X wins");
            return true;
        } else if (checkWinner(cells, 'O')) {
            System.out.println("O wins");
            return true;
        } else if (isBoardFull(cells)) {
            System.out.println("Draw");
            return true;
        }

        return false;
    }

    public static boolean checkWinner(char[] cells, char symbol) {
        // Перевірка на перемогу гравця з символом 'X' або 'O'

        // Перевірка по горизонталі і вертикалі
        for (int i = 0; i < 3; i++) {
            // Перевірка по горизонталі
            if (cells[i * 3] == symbol && cells[i * 3 + 1] == symbol && cells[i * 3 + 2] == symbol) {
                return true;
            }

            // Перевірка по вертикалі
            if (cells[i] == symbol && cells[i + 3] == symbol && cells[i + 6] == symbol) {
                return true;
            }
        }

        // Перевірка по діагоналі (ліворуч направо)
        if (cells[0] == symbol && cells[4] == symbol && cells[8] == symbol) {
            return true;
        }

        // Перевірка по діагоналі (праворуч направо)
        if (cells[2] == symbol && cells[4] == symbol && cells[6] == symbol) {
            return true;
        }

        return false;
    }

    public static boolean isBoardFull(char[] cells) {
        // Перевірка, чи ігрове поле повне (нічия)
        for (char cell : cells) {
            if (cell == ' ') {
                return false;
            }
        }
        return true;
    }
}
