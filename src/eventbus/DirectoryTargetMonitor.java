package eventbus;

import java.nio.file.*;

public class DirectoryTargetMonitor {

    private WatchService watchService;
    private final EventBus eventBus;
    private final Path path;
    private volatile boolean start = false;

    public DirectoryTargetMonitor(final EventBus eventBus, final String targetPath) {
        this(eventBus, targetPath, "");
    }

    //构造Monitor的时候需要传⼊EventBus以及需要监控的⽬录
    public DirectoryTargetMonitor(final EventBus eventBus,
                                  final String targetPath,final String... morePaths)
    {
        this.eventBus = eventBus;
        this.path = Paths.get(targetPath, morePaths);
    }


    public void startMonitor() throws Exception
    {
        this.watchService = FileSystems.getDefault().newWatchService();
        //为路径注册感兴趣的事件
        this.path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_CREATE);
        System.out.printf("The directory [%s] is monitoring... \n", path);
        this.start = true;
        while (start)
        {
            WatchKey watchKey = null;
            try
            {
                //当有事件发⽣时会返回对应的WatchKey
                watchKey = watchService.take();
                watchKey.pollEvents().forEach(event ->
                {
                    WatchEvent.Kind<?> kind = event.kind();
                    Path path = (Path) event.context();
                    Path child = DirectoryTargetMonitor.this.path.resolve(path);
                    //提交FileChangeEvent到EventBus
                    eventBus.post(new FileChangeEvent(child, kind));
                });
            } catch (Exception e)
            {
                this.start = false;
            } finally
            {
                if (watchKey != null)
                    watchKey.reset();
            }
        }
    }
    public void stopMonitor() throws Exception
    {
        System.out.printf("The directory [%s] monitor will be stop...\n", path);
        Thread.currentThread().interrupt();
        this.start = false;
        this.watchService.close();
        System.out.printf("The directory [%s] monitor will be stop done.\n", path);
    }
}
