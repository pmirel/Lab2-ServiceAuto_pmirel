package Domain;

public class Transaction {
    private int id;
    private int carId;
    private int clientId;
    private double priceParts;
    private double priceWork;
    private String date;
    private String hour;
    private boolean discount;
    private double totalPrice;

    public Transaction(int id, int carId, int clientId, double priceParts, double priceWork, String date, String hour) {
        this.id = id;
        this.carId = carId;
        this.clientId = clientId;
        this.priceParts = priceParts;
        this.priceWork = priceWork;
        this.date = date;
        this.hour = hour;
        this.discount = discount;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", carId=" + carId +
                ", clientId=" + clientId +
                ", priceParts=" + priceParts +
                ", priceWork=" + priceWork +
                ", date='" + date + '\'' +
                ", hour='" + hour + '\'' +
                ", discount=" + discount +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public double getPriceParts() {
        return priceParts;
    }

    public void setPriceParts(double priceParts) {
        this.priceParts = priceParts;
    }

    public double getPriceWork() {
        return priceWork;
    }

    public void setPriceWork(double priceWork) {
        this.priceWork = priceWork;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
