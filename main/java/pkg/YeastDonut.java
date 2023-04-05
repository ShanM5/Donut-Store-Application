package pkg;

import pkg.MenuItem;

public class YeastDonut extends MenuItem {
    private String flavor;
    @Override
    public double itemPrice() {
        return 0;
    }
    //You must provide at least 6 flavors for yeast donuts,
    // at least 3 flavors for cake donuts and donut holes each.
}
