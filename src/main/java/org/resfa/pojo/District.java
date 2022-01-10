package org.resfa.pojo;

public enum District {
    Admiralteisky(1, "admiralteisky.txt"),
    Centralnyj(2, "centralnyj.txt"),
    Frunzensky(3, "frunzensky.txt"),
    Kalininsky(4, "kalininsky.txt"),
    Kirovsky(5, "kirovsky.txt"),
    Kolpinsky(6, "kolpinsky.txt"),
    Krasnogvardesky(7, "krasnogvardesky.txt"),
    Krasnoselsky(8, "krasnoselsky.txt"),
    Kronstadtsky(9, "kronstadtsky.txt"),
    Kurortnyj(10, "kurortnyj.txt"),
    Moskovsky(11, "moskovsky.txt"),
    Nevsky(12, "nevsky.txt"),
    Petrodvorcovyj(13, "petrodvorcovyj.txt"),
    Petrogradsky(14, "petrogradsky.txt"),
    Primorsky(15, "primorsky.txt"),
    Pushkinsky(16, "pushkinsky.txt"),
    Vasileostrovsky(17, "vasileostrovsky.txt"),
    Vyborgsky(18, "vyborgsky.txt");

    private String name;
    private int number;

    District(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}
