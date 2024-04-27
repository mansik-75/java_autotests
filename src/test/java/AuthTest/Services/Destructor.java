package AuthTest.Services;

import AuthTest.ApplicationManager;

public class Destructor {
    public static Thread addDestructor(Runnable runnable) {
        Thread hook = new Thread(runnable);
        Runtime.getRuntime().addShutdownHook(hook);
        return hook;
    }

    public static boolean removeDestructor(Thread hook) {
        return Runtime.getRuntime().removeShutdownHook(hook);
    }

    public static Thread addManagerDestructor(ApplicationManager applicationManager) {
        return addDestructor(() -> {
            try {
                applicationManager.stop();
            } catch (Exception ignored) {
            }
        });
    }
}
