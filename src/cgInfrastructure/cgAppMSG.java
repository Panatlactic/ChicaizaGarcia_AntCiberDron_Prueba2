package cgInfrastructure;

import javax.swing.JOptionPane;

public abstract class cgAppMSG {

    private cgAppMSG() {}
    public static final void CEshow(String msg){
        JOptionPane.showMessageDialog(null, msg, "🐜 AntCiberDron", JOptionPane.INFORMATION_MESSAGE);
    }
    public static final void CEshowError(String msg){
        JOptionPane.showMessageDialog(null, msg, "💀 AntCiberDron", JOptionPane.OK_OPTION);
    }
    public static final boolean CEshowConfirmYesNo(String msg){
        return (JOptionPane.showConfirmDialog(null, msg, "🐜 AntCiberDron", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }

}
