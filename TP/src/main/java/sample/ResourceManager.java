package sample;


public class ResourceManager {
    private static ResourceManager INSTANCE;
    private final KlientStorage klientStorage;
    private final FakturyStorage fakturyStorage;

    public KlientStorage getKlientStorage() {
        return klientStorage;
    }

    public FakturyStorage getFakturyStorage() {
        return fakturyStorage;
    }


    private ResourceManager() {
        klientStorage = new KlientStorage();
        fakturyStorage = new FakturyStorage();
    }

    public static ResourceManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ResourceManager();
        }
        return INSTANCE;
    }
}
