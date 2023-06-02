import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class ordenarComBubbleSort extends JFrame {
    private JTextArea inputArea;
    private JTextArea outputArea;

    public ordenarComBubbleSort() {
        setTitle("Ordenação");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputArea = new JTextArea(10, 20);
        inputArea.setLineWrap(true);
        panel.add(new JScrollPane(inputArea), BorderLayout.NORTH);

        JButton sortButton = new JButton("Ordenar");
        sortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputArea.getText();
                int[] numbers = readNumbers(input);
                bubbleSort(numbers);
                displaySortedNumbers(numbers);
            }
        });
        panel.add(sortButton, BorderLayout.CENTER);

        outputArea = new JTextArea(10, 20);
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        panel.add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        add(panel);
        pack();
        setLocationRelativeTo(null);
    }

    private int[] readNumbers(String input) {
        Scanner scanner = new Scanner(input);
        int count = 0;
        while (scanner.hasNextInt()) {
            count++;
            scanner.nextInt();
        }
        int[] numbers = new int[count];
        scanner = new Scanner(input);
        for (int index = 0; index < count; index++) {
            numbers[index] = scanner.nextInt();
        }
        return numbers;
    }

    private void bubbleSort(int[] numbers) {
        int numeros = numbers.length;
        for (int index = 0; index < numeros - 1; index++) {
            for (int j = 0; j < numeros - index - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    private void displaySortedNumbers(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number).append(" - ");
        }
        outputArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ordenarComBubbleSort().setVisible(true);
            }
        });
    }
}
