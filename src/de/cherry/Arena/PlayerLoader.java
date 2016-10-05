package de.cherry.Arena;

import de.cherry.battleship.Player;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Vector;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/**
 * Created by Max on 05.10.2016.
 */
public class PlayerLoader {

    private Vector<Player> loadedplugins = new Vector<Player>();

    public Player load(File jar) {
        File[] files = jar.listFiles();
        for (File f : files)
            loadPlugin(f);
        for (Player pi : loadedplugins)
            return pi;

        return null;
    }

//    public void stop() {
//        for (PluginInterface pi : loadedplugins)
//            pi.stop();
//    }

    public void loadPlugin(File file) {


        try {
            JarFile jfile = new JarFile(file);
            Manifest manifest = jfile.getManifest();
            Attributes attrib = manifest.getMainAttributes();
            String main = attrib.getValue(Attributes.Name.MAIN_CLASS);


            Class cl = new URLClassLoader(new URL[]{file.toURL()}).loadClass(main);

            Class[] interfaces = cl.getInterfaces();
            boolean isplugin = false;
            for (int y = 0; y < interfaces.length && !isplugin; y++)
                if (interfaces[y].getName().equals("de.maxxes.PluginInterface"))
                    isplugin = true;
            if (isplugin) {
                Player plugin = (Player) cl.newInstance();
                loadedplugins.add(plugin);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
