package util;

public enum Locale {
    RU("ru_RU"),
    EN("en_US"),
    BY("be_BY");

    private String name;

    Locale(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static String getStr(String s){
        for (Locale l:values()){
            if (l.name.equals(s)){
                return l.name;
            }
        }
        return null;
    }
}