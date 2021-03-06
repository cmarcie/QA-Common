package de.funke.qa.common.enumeration;


public enum Publication {
    HAO("hao", "abendblatt", "hao", true),
    BZV_BZ("bzv-bz", "braunschweiger-zeitung", "bzv", false),
    NRW_WAZ("nrw-waz", "waz", "nrw", false),
    BMO24("bmo24", "live.morgenpost", "bmo", false),
    BMO("bmo", "morgenpost", "hao", false);


    private final String name;
    private final String domain;
    private final String portal;
    private final boolean isHttpsForced;

    Publication(String name, String domain, String portal, boolean isHttpsForced) {
        this.name = name;
        this.domain = domain;
        this.portal = portal;
        this.isHttpsForced = isHttpsForced;
    }

    public static Publication getPublication(String url){
        String availablePublications = "";
        for(Publication publication : Publication.values()){
            availablePublications = availablePublications + ", " + publication.getName();
            if(url.contains(publication.getDomain())){
                return publication;
            }
        }
        throw new IllegalStateException("Available Publications: " + availablePublications +  "There is no publication for this url: " + url);
    }

    public String getName() {
        return name;
    }

    public String getDomain() {
        return domain;
    }

    public boolean isHttpsForced() {
        return isHttpsForced;
    }
}
