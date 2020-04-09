package sample;

import javafx.application.Platform;
import sun.plugin.services.WPlatformService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManager {

    private static ExecutorService executorService;
    private static Controller controller;

    public ThreadManager(Controller ct){
        controller = ct;
    }

    public void init(){
        executorService = Executors.newFixedThreadPool(1);
        executorService.submit(new Thread_Server(controller));
    }
    public void Info_Output(String str){ Platform.runLater(() -> controller.Write_data(str)); }

}
