
public class LogManager {
    public void log(int logType){
        if(logType == 1){
            System.out.println("Veritabanina loglandi");
        } else if(logType == 2){
            System.out.println("Dosyaya loglandı.");
        } else {
            System.out.println("Email loglandı.");
        }
    }
}
