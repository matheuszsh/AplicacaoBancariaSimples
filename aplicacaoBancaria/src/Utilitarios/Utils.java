package Utilitarios;

import jdk.jshell.execution.Util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    static NumberFormat transformaNumero = new DecimalFormat("R$ #,##0.00");
    static SimpleDateFormat transformaData = new SimpleDateFormat("dd/MM/yyyy");

    public static String doubleParaString(double valor){
        return Utils.transformaNumero.format(valor);
    }

    public static String dataParaString(Date data){
        return Utils.transformaData.format(data);
    }
}
