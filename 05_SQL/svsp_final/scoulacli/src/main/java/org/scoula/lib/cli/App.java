package org.scoula.lib.cli;

import org.scoula.lib.cli.command.*;
import org.scoula.lib.cli.exception.BadMenuException;
import org.scoula.lib.cli.ui.Menu;

public abstract class App {
    Menu menu;

    public App() {
    }

    public void init() {
        menu = new Menu();
        createMenu(menu);
    }

    public void createMenu(Menu menu) {
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        init();
        while (true) {
            menu.printMenu();
            try {
                Command command = menu.getSelect();
                command.execute();
            } catch (BadMenuException e) {
                e.printStackTrace();
//                System.out.println(e.getMessage());
            }
        }
    }

}
