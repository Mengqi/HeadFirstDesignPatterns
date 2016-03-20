import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ImageProxyTestDrive {
    ImageComponent imageComponent;
    JFrame frame = new JFrame("CD Cover Viewer");
    JMenuBar menuBar;
    JMenu menu;
    Hashtable<String, String> cds = new Hashtable<String, String>();

    public ImageProxyTestDrive() throws Exception {
        cds.put("Ambient: Music for Airports", "https://upload.wikimedia.org/wikipedia/en/4/46/Music_for_Airports.jpg");
        cds.put("Buddha Bar", "http://ecx.images-amazon.com/images/I/61ZN%2BBfxsoL.jpg");
        cds.put("Ima", "https://upload.wikimedia.org/wikipedia/en/6/69/Bt_ima.jpg");
        cds.put("Karma", "http://cdn.discogs.com/UEXnb0y2SndFElJ-ytlGeckQMxI=/fit-in/300x300/filters:strip_icc():format(jpeg):mode_rgb()/discogs-images/R-3331936-1326121607.jpeg.jpg");
        cds.put("MCMXC A.D.", "https://upload.wikimedia.org/wikipedia/en/1/10/MCMXC_aD_Enigma_cover.jpg");
        cds.put("Northern Exposure", "http://eil.com/images/main/Sasha+Northern+Exposure+516177.jpg");
        cds.put("Selected Ambient Works, Vol. 2", "http://s3.amazonaws.com/quietus_production/images/articles/14552/selectedambientworksII_1392901389_crop_550x550.jpg");
        cds.put("oliver", "http://www.lpsoncd.com/media/ecom/prodlg/Oliver116.jpg");

        URL initialURL = new URL(cds.get("Selected Ambient Works, Vol. 2"));
        menuBar = new JMenuBar();
        menu = new JMenu("Favorite CDs");
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        for (Enumeration<String> e = cds.keys(); e.hasMoreElements();) {
            String name = e.nextElement();
            JMenuItem menuItem = new JMenuItem(name);
            menu.add(menuItem);
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    imageComponent.setIcon(new ImageProxy(getCDURL(event.getActionCommand())));
                    frame.repaint();
                }
            });
        }

        // set up frame and menus
        Icon icon = new ImageProxy(initialURL);
        imageComponent = new ImageComponent(icon);
        frame.getContentPane().add(imageComponent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    private URL getCDURL(String name) {
        try {
            return new URL((String)cds.get(name));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        ImageProxyTestDrive testDrive = new ImageProxyTestDrive();
    }

}
