boolean isIPv4Address(String inputString) {
    String regex="^([0-9]{1}|[1-9][0-9]|[1][0-9][0-9]|[2][0-4][0-9]|[2][5][0-5])\\.([0-9]{1}|[1-9][0-9]|[1][0-9][0-9]|[2][0-4][0-9]|[2][5][0-5])\\.([0-9]{1}|[1-9][0-9]|[1][0-9][0-9]|[2][0-4][0-9]|[2][5][0-5])\\.([0-9]{1}|[1-9][0-9]|[1][0-9][0-9]|[2][0-4][0-9]|[2][5][0-5])$";
     Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
     Matcher matcher = pattern.matcher(inputString);
     return matcher.find();
}
