package odoexekutatu;

import java.net.URI;

public class OdooExekutatu 
{
    public static void main( String[] args )
    {
        try {
            URI url = new URI("http://localhost:8069/web?db=pcBox#cids=1&default_active_id=mail.box_inbox&action=113&menu_id=79&active_id=mail.box_inbox");
            java.awt.Desktop.getDesktop().browse(url);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
