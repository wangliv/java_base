package eventbus;

public class FileChangeListener {

    @Subscribe
    public void onChange(FileChangeEvent event)
    {
        System.out.printf("%s-%s\n", event.getPath(), event.getKind());
    }
}
