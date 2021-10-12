package com.sketch01.api.opm.data;

public class VueRouterDao {

    private final String routerPath;
    private final String routerName;
    private final String vuePath;

    public VueRouterDao(String routerPath, String routerName, String vuePath) {
        this.routerPath = routerPath;
        this.routerName = routerName;
        this.vuePath = vuePath;
    }

    public String getRouterPath() {
        return routerPath;
    }

    public String getRouterName() {
        return routerName;
    }

    public String getVuePath() {
        return vuePath;
    }
}
