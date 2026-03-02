package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Tela extends JFrame {

    Color cinzaClaro = new Color(212, 212, 210);
    Color cinzaEscuro = new Color(80, 80, 80);
    Color preto = new Color(28, 28, 28);
    Color laranja = new Color(78, 28, 72);

    JPanel displayPainel = new JPanel();
    JLabel displayLabel = new JLabel();
    JPanel buttonsPanel = new JPanel();

    String[] buttonValues = {
            "AC", "+/-", "%", "÷",
            "7", "8", "9", "×",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "√", "="
    };

    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};

    String a = "0";
    String operador = null;
    String b = null;


    public Tela() {
        // configuracao da tela
        setSize(360, 540);
        setTitle("Minha Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        // icone

        ImageIcon icone = new ImageIcon(getClass().getResource("../assets/apple-calculator.png"));
        setIconImage(icone.getImage());

        // config diplay

        displayLabel.setBackground(preto);
        displayLabel.setForeground(Color.white);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 80));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0");
        displayLabel.setOpaque(true);

        displayPainel.setLayout(new BorderLayout());
        displayPainel.add(displayLabel);
        add(displayPainel, BorderLayout.NORTH);

        // config botoes

        buttonsPanel.setLayout(new GridLayout(5, 4));
        buttonsPanel.setBackground(preto);
        add(buttonsPanel);

        // config botoes -> ve no array e adiciona o botao com as minhas config

        for (int i = 0; i < buttonValues.length; i++) {
            JButton botao = new JButton(); // cria um botao
            String valorBotao = buttonValues[i]; // atribui uma string a um valor que ta no array
            botao.setFont(new Font("Arial", Font.PLAIN, 30)); // seta a fonte que quero e o tamanho do texto
            botao.setFocusable(false);
            botao.setText(valorBotao); // seta o texto que ta definido pelo array
            botao.setBorder(new LineBorder(preto));

            if (Arrays.asList(topSymbols).contains(valorBotao)) {
                botao.setBackground(cinzaClaro);
                botao.setForeground(preto);
            } else if (Arrays.asList(rightSymbols).contains(valorBotao)) {
                botao.setBackground(laranja);
                botao.setForeground(Color.white);
            } else {
                botao.setBackground(cinzaEscuro);
                botao.setForeground(Color.white);
            }

            buttonsPanel.add(botao); // e adiciona o meu JButton ao Painel botao;

            botao.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    String buttonValue = button.getText();
                    if (Arrays.asList(rightSymbols).contains(buttonValue)) {
                        if (buttonValue.contains("=")) {
                            if (a != null) { // se a for diferente de nulo eh pq tem um valor e vai pegar B
                                b = displayLabel.getText();
                                double numA = Double.parseDouble(a);
                                double numB = Double.parseDouble(b); // convetidos pra double

                                if (operador.contains("+")) {
                                    double result = numA + numB;
                                    displayLabel.setText(removerZeroDecimal(result));
                                } else if (operador.contains("-")) {
                                    double result = numA - numB;
                                    displayLabel.setText(removerZeroDecimal(result));
                                } else if (operador.contains("×")){
                                    double result = numA * numB;
                                    displayLabel.setText(removerZeroDecimal(result));
                                } else if (operador.contains("÷")) {
                                    double result = numA / numB;
                                    displayLabel.setText(removerZeroDecimal(result));
                                }

                            }

                        } else if ("+-÷×".contains(buttonValue)) {
                            if (operador == null) {
                                a = displayLabel.getText();
                                displayLabel.setText("0");
                                b = "0";
                            }
                            operador = buttonValue; // essa linha é apenas para o operador passar a ter um valor
                            // depois de clicar uma vez, ou seja, nao pode usar mais de uma vez o operador
                        }

                    } else if (Arrays.asList(topSymbols).contains(buttonValue)) {
                        if (buttonValue.contains("AC")) {
                            limpaTudo();
                            displayLabel.setText("0");
                        } else if (buttonValue.contains("+/-")) {
                            double numDisplay = Double.parseDouble(displayLabel.getText());
                            numDisplay *= -1;
                            displayLabel.setText(removerZeroDecimal((numDisplay)));
                        } else if (buttonValue.contains("%")) {
                            double numDisplay = Double.parseDouble(displayLabel.getText());
                            numDisplay /= 100;
                            displayLabel.setText(removerZeroDecimal((numDisplay)));
                        }
                    } else { // digitos ou "."
                        if (buttonValue == ".") {
                            if (!displayLabel.getText().contains(buttonValue)) {
                                displayLabel.setText(displayLabel.getText() + buttonValue);
                            }

                        } else if ("0123456789".contains(buttonValue)) {
                            if (displayLabel.getText() == "0") {
                                displayLabel.setText(buttonValue);
                            } else {
                                displayLabel.setText(displayLabel.getText() + buttonValue);
                            }
                        } else {
                            double numeroDouble = Double.parseDouble(displayLabel.getText());
                            double raiz = Math.sqrt(numeroDouble);
                            displayLabel.setText(removerZeroDecimal(raiz));
                        }
                    }
                }
            });
        }

        setVisible(true);
    }

    void limpaTudo() {
        a = "0";
        b = null;
        operador = null;
    }

    String removerZeroDecimal(double numDisplay) {
        if (numDisplay % 1 == 0) {
            return Integer.toString((int) numDisplay); // casting de tipagem -> double quer virar int pra virar String
        }
        return Double.toString(numDisplay);
    }


}
