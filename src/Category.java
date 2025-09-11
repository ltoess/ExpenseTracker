public enum Category {
    FOOD, GROCERIES, TRANSPORT, ENTERTAINMENT, UTILITIES, OTHER;

    // store and validate category entries

    public static Category fromString(String s) {
        if (s == null) 
            return OTHER;
        try {
            return Category.valueOf(s.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return OTHER;
        }
    }
}
