package sample;


public class ResourceManager {
    private static ResourceManager INSTANCE;
    private final KlientStorage klientStorage;
    private final FakturyStorage fakturyStorage;
    private final ILoader loader;

    public KlientStorage getKlientStorage() {
        return klientStorage;
    }

    public FakturyStorage getFakturyStorage() {
        return fakturyStorage;
    }


    private ResourceManager() {
        klientStorage = new KlientStorage();
        fakturyStorage = new FakturyStorage();
        loader = new MockingLoader();
    }

    public static ResourceManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ResourceManager();
        }
        return INSTANCE;
    }

    public void load(){loader.load();}
}
