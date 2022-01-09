package org.resfa.pojo;

public enum District {
    Admiralteisky("admiralteisky.txt"),
    Centralnyj("centralnyj.txt"),
    Frunzensky("frunzensky.txt"),
    Kalininsky("kalininsky.txt"),
    Kirovsky("kirovsky.txt"),
    Kolpinsky("kolpinsky.txt"),
    Krasnogvardesky("krasnogvardesky.txt"),
    Krasnoselsky("krasnoselsky.txt"),
    Kronstadtsky("kronstadtsky.txt"),
    Kurortnyj("kurortnyj.txt"),
    Moskovsky("moskovsky.txt"),
    Nevsky("nevsky.txt"),
    Petrodvorcovyj("petrodvorcovyj.txt"),
    Petrogradsky("petrogradsky.txt"),
    Primorsky("primorsky.txt"),
    Pushkinsky("pushkinsky.txt"),
    Vasileostrovsky("vasileostrovsky.txt"),
    Vyborgsky("vyborgsky.txt");

    private String name;

    District(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
