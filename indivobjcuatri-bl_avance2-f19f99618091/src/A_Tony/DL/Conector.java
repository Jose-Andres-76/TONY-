package bl_avance2.src.A_Tony.DL;

import bl_avance2.src.A_Tony.UTILS.Utils;

public class Conector {
    private static AccessBD coneccionBD = null;

    public static AccessBD getConector() throws Exception {
        String[] infoBD = Utils.getProperties();
        String URL = infoBD[0] + "//" + infoBD[1] + ":" + infoBD[2] + "/" + infoBD[3];
        String user = infoBD[5];
        String password = infoBD[6];

        if (coneccionBD == null) {
            coneccionBD = new AccessBD(URL, user, password);
        }

        return coneccionBD;
    }
}
