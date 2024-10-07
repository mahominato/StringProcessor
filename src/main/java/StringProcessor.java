public class StringProcessor {
    public boolean isStrongPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    public int calculateDigits(String sentence) {
        int count = 0;
        for (char c : sentence.toCharArray()) {
            if (Character.isDigit(c)) {
                count++;
            }
        }
        return count;
    }

    public int calculateWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;
        }
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }

    public double calculateExpression(String expression) {
        return new Object() {
            int index = 0;

            double parse() {
                double value = parseTerm();
                while (index < expression.length()) {
                    char operator = expression.charAt(index);
                    if (operator == '+') {
                        index++;
                        value += parseTerm();
                    } else if (operator == '-') {
                        index++;
                        value -= parseTerm();
                    } else {
                        break;
                    }
                }
                return value;
            }

            double parseTerm() {
                double value = parseFactor();
                while (index < expression.length()) {
                    char operator = expression.charAt(index);
                    if (operator == '*') {
                        index++;
                        value *= parseFactor();
                    } else if (operator == '/') {
                        index++;
                        value /= parseFactor();
                    } else {
                        break;
                    }
                }
                return value;
            }

            double parseFactor() {
                double value;
                if (expression.charAt(index) == '(') {
                    index++;
                    value = parse();
                    index++;
                } else {
                    int start = index;
                    while (index < expression.length() && Character.isDigit(expression.charAt(index))) {
                        index++;
                    }
                    value = Double.parseDouble(expression.substring(start, index));
                }
                return value;
            }
        }.parse();
    }
}
