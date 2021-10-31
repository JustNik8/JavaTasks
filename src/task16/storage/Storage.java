package task16.storage;

import task16.ordersmanagers.internetordersmanager.InternetOrdersManager;
import task16.ordersmanagers.tableordersmanager.TableOrdersManager;

public class Storage {
    private static InternetOrdersManager internetInstance;
    private static TableOrdersManager tableInstance;

    private Storage() { }

    public static InternetOrdersManager getInternetOrdersManager(){
        if (internetInstance == null){
            internetInstance = new InternetOrdersManager();
        }
        return internetInstance;
    }

    public static TableOrdersManager getTableOrdersManager(){
        if (tableInstance == null){
            tableInstance = new TableOrdersManager();
        }
        return tableInstance;
    }
}
