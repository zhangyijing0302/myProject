package com.myProject.javaBase.base;

/**
 * 双亲委派（Parents Delegation Model）
 *
 * 向上穿透 拓展类加载器和核心类库 两个亲人
 *
 * Java源代码 -> .class的字节码文件 -> ClassLoader负责将这些class文件给加载到JVM中
 *
 * JVM中提供了三层的ClassLoader：
 *
 * Bootstrap classLoader:主要负责加载核心的类库(java.lang.*等)，构造ExtClassLoader和APPClassLoader。
 *
 * ExtClassLoader：主要负责加载jre/lib/ext目录下的一些扩展的jar。
 *
 * AppClassLoader：主要负责加载应用程序的主函数类
 *
 *
 * 当获取parent是null时，代表获取到的时顶级类加载器，Bootstrap类加载器。
 *
 * 当一个Hello.class这样的文件要被加载时。不考虑我们自定义类加载器，首先会在AppClassLoader中检查是否加载过，如果有那就无需再加载了。
 * 如果没有，那么会拿到父加载器，然后调用父加载器的loadClass方法。父类中同理也会先检查自己是否已经加载过，如果没有再往上。注意这个类似递归的过程，
 * 直到到达Bootstrap classLoader之前，都是在检查是否加载过，并不会选择自己去加载。直到BootstrapClassLoader，已经没有父加载器了，
 * 这时候开始考虑自己是否能加载了，如果自己无法加载，会下沉到子加载器去加载，一直到最底层，如果没有任何加载器能加载，就会抛出ClassNotFoundException
 * 优点：
 * 1.保证安全性，层级关系代表优先级，也就是所有类的加载，优先给启动类加载器，这样就保证了核心类库类。
 *
 * 2.避免重复，如果父类加载器加载过了，子类加载器就没有必要再去加载了。
 */
public class 双亲委派机制 {



// java.lang.ClassLoader.loadClass(java.lang.String, boolean)

//    protected Class<?> loadClass(String name, boolean resolve)
//            throws ClassNotFoundException
//    {
//        // 首先，检查是否已经被类加载器加载过
//        Class<?> c = findLoadedClass(name);
//        if (c == null) {
//            try {
//                // 存在父加载器，递归的交由父加载器
//                if (parent != null) {
//                    c = parent.loadClass(name, false);
//                } else {
//                    // 直到最上面的Bootstrap类加载器
//                    c = findBootstrapClassOrNull(name);
//                }
//            } catch (ClassNotFoundException e) {
//                // ClassNotFoundException thrown if class not found
//                // from the non-null parent class loader
//            }
//
//            if (c == null) {
//                // If still not found, then invoke findClass in order
//                // to find the class.
//                c = findClass(name);
//            }
//        }
//        return c;
//    }

}
