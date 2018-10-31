package classloader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {

    private final static Path DEAFULT_CLASS_DIR = Paths.get("F:","classloader");

    private final Path classDir;

    public MyClassLoader() {
        this.classDir = DEAFULT_CLASS_DIR;
    }

    public MyClassLoader(Path classDir) {
        this.classDir = classDir;
    }

    public MyClassLoader(ClassLoader parent) {
        super(parent);
        this.classDir = DEAFULT_CLASS_DIR;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] clazzbytes = this.readClassBytes(name);
        if(null == clazzbytes || clazzbytes.length == 0)
            throw new ClassNotFoundException("this class" + name + "not found");

        return this.defineClass(name,clazzbytes,0,clazzbytes.length);
    }

    private byte[] readClassBytes(String name) throws ClassNotFoundException {
        String classPath =  name.replace(".","/");
        Path classFullPath = classDir.resolve(Paths.get(classPath+".class"));
        if(!classFullPath.toFile().exists()){
            throw new ClassNotFoundException("this class"+ name +" not found");
        }
        try(ByteArrayOutputStream out = new ByteArrayOutputStream()){
            Files.copy(classFullPath,out);
            return out.toByteArray();
        }catch (IOException e){
            throw new ClassNotFoundException("load class "+ name + " occur");
        }
    }
}
