package service;
public class BackupService {
    public void backupDB() throws Exception {
        Runtime.getRuntime().exec(
            "mysqldump -u root -ppassword retail_db > backup.sql"
        );
    }
}