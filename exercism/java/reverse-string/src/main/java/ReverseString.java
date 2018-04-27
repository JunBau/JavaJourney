class ReverseString {

    String reverse(String inputString) {
        StringBuilder newInputString = new StringBuilder();

        newInputString.append(inputString);

        newInputString.reverse();

        return newInputString.toString();
    }

}