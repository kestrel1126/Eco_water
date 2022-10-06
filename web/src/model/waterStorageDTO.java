package src.model;

public class waterStorageDTO {
    float storage;
    String date;

    public waterStorageDTO(float storage, String date){
        this.storage = storage;
        this.date = date;
    }

    public waterStorageDTO(){

    }

    public float getStorage() {
        return storage;
    }

    public void setStorage(float storage) {
        this.storage = storage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
