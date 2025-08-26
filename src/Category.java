public enum Category {
    FOOD, TRANSPORT, ENTERTAINMENT, UTILITIES, OTHER;

    public static Category fromString(String s) {
        if (s == null) return OTHER;
        try {
            return Category.valueOf(s.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return OTHER;
        }
    }
}
