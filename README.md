# Java Swing Calculator

A desktop calculator application built with Java and Swing.  
This project was developed to practice Java fundamentals, GUI development, and event-driven programming.

---

## 📸 Preview

Simple calculator inspired by the macOS calculator design.

---

## 🚀 Features

- Addition (+)
- Subtraction (-)
- Multiplication (×)
- Division (÷)
- Percentage (%)
- Square Root (√)
- Sign inversion (+/-)
- Decimal numbers
- Clear function (AC)
- Custom UI styling with colors and layout

---

## 🛠 Technologies Used

- Java
- Swing (JFrame, JPanel, JButton, JLabel)
- AWT (Color, Font, Layout Managers)

---

## 🧠 How It Works

The calculator operates using three main variables:

- `a` → first number
- `operador` → selected operation
- `b` → second number

### Flow:

1. User selects the first number.
2. User selects an operator (+, -, ×, ÷).
3. User selects the second number.
4. When "=" is pressed:
   - The values are converted to `double`
   - The operation is performed
   - The result is displayed
   - Trailing `.0` is removed for cleaner output

---

## 🎨 UI Structure

The application is divided into:

- **Display Panel** → Shows current input/result
- **Buttons Panel** → GridLayout (5 rows x 4 columns)
- Buttons are styled dynamically based on their role:
  - Top buttons (AC, +/-, %) → Light gray
  - Operators → Custom purple
  - Numbers → Dark gray

---

## 📂 Project Structure

```bash
java-swing-calculator/
│
├── src/
│   ├── assets/
│   │   └── apple-calculator.png
│   │
│   ├── view/
│   │   └── Tela.java
│   │
│   └── Main.java
│
├── .gitignore
├── Calculadora.iml
└── README.md
```


### Structure Explanation

- `Main.java` → Application entry point.
- `view/Tela.java` → Main calculator UI and logic.
- `assets/` → Icons and image resources.
- `.gitignore` → Git ignored files configuration.
- `.iml` → IntelliJ project configuration file.
