package org.resfa.pojo;

public enum District {
    Admiralteisky(1, "admiralteisky.txt", "Адмиралтейский"),
    Centralnyj(2, "centralnyj.txt", "Цетральный"),
    Frunzensky(3, "frunzensky.txt", "Фрунзенский"),
    Kalininsky(4, "kalininsky.txt", "Калининский"),
    Kirovsky(5, "kirovsky.txt", "Кировский"),
    Kolpinsky(6, "kolpinsky.txt", "Колпинский"),
    Krasnogvardesky(7, "krasnogvardesky.txt", "Красногвардейский"),
    Krasnoselsky(8, "krasnoselsky.txt", "Красносельский"),
    Kronstadtsky(9, "kronstadtsky.txt", "Кронштадский"),
    Kurortnyj(10, "kurortnyj.txt", "Курортный"),
    Moskovsky(11, "moskovsky.txt", "Московский"),
    Nevsky(12, "nevsky.txt", "Невский"),
    Petrodvorcovyj(13, "petrodvorcovyj.txt", "Петродворцовый"),
    Petrogradsky(14, "petrogradsky.txt", "Петроградский"),
    Primorsky(15, "primorsky.txt", "Приморский"),
    Pushkinsky(16, "pushkinsky.txt", "Пушкинский"),
    Vasileostrovsky(17, "vasileostrovsky.txt", "Василеостровкий"),
    Vyborgsky(18, "vyborgsky.txt", "Выборгский");

    private String fileName;
    private String name;
    private int number;

    District(int number, String fileName, String name) {
        this.number = number;
        this.fileName = fileName;
        this.name = name;
    }

    public String getFileName() {
        return fileName;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}
