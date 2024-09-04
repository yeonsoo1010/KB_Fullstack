package org.scoula.lib.cli;

import org.scoula.lib.cli.command.*;
import org.scoula.lib.cli.ui.Menu;
import org.scoula.lib.cli.ui.MenuItem;

public abstract class App {
    Menu menu;
    public App() {

    }

    public void init() {
        menu = new Menu();
        createMenu(menu);
        menu.add(new MenuItem("종료", new ExitCommand()));
    }

    public void createMenu(Menu menu) {
    }

    public void run() {
        init();
        while (true) {
            try {
                menu.printMenu();
                Command command = menu.getSelect();
                command.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

}