package ejercicios11;

import java.io.File;

public class Ejercicio8Clase extends File {

    public Ejercicio8Clase(String pathname) {
        super(pathname);
    }

    public String showInfo(){

        String info = "Nombre: " + this.getName() + "\n" +
                "Ruta: " + this.getPath() + "\n" +
                "Ruta absoluta: " + this.getAbsolutePath() + "\n" +
                "¿Se puede leer?: " + this.canRead() + "\n" +
                "¿Se puede escribir?: " + this.canWrite() + "\n" +
                "Tamaño: " + this.length()+ " Bytes" + "\n" +
                "¿Es un directorio?: " + this.isDirectory() + "\n" +
                "¿Es un fichero?: " + this.isFile() + "\n";

        if (this.isDirectory()) {
            info += "Contenido del directorio:\n";
            String [] contenidos = this.list();
            if (contenidos != null) {
                for (String temp : contenidos){
                    info += temp + "\n";
                }
            } else {
                info += "No se puede listar el contenido:\n";
            }
        }
        return info;
    }
    //Metodo para sumar los archivos de la carpeta y que no te de
    // 0 bytes si no el peso real
    /*public long getDirSize(){
        long totalSize = 0;
        if (this.isDirectory()) {
            totalSize += this.length();
            File[] files = this.listFiles();
            for (File f : files) {
                Ejercicio8Clase e = new Ejercicio8Clase(f.getPath());
                if (!(e.isDirectory())) {
                    totalSize += e.length();
                }
                else {totalSize += e.getDirSize();}
            }
        } else {
            totalSize = this.length();
        }
        return totalSize;
    }*/
}
