boolean variableName(String name) {
     String regex = "^([a-zA-Z_]{1}[\\da-zA-Z_]*)$";
     Pattern pattern = Pattern.compile(regex);
     Matcher matcher = pattern.matcher(name);
    return matcher.find();
}
