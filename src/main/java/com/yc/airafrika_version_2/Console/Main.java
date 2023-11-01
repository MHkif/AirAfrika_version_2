package com.yc.airafrika_version_2.Console;

import com.yc.airafrika_version_2.Console.Controllers.Navigator;
import com.yc.airafrika_version_2.Utils.Session;

public class Main {
    public  static Session SESSION = Session.getInstance();

    public static void main(String[] args) {
        Navigator.INSTANCE().index();
    }

}
