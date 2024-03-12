package ra.bussiness;

import java.util.Scanner;

public class Book {
    private static int nextId = 1;
    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus = true;

    public Book(){
        this.bookId = nextId++;
    }

    public Book(int bookId, String bookName, String author, String descriptions, double importPrice, double exportPrice, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData(Scanner scanner){
//        Nhập tên sách
        System.out.println("Nhập tên sách :");
        while (true){
            bookName = scanner.nextLine();
            if (!bookName.isEmpty()){
                break;
            }else {
                System.err.println("Tên sách không được để trống. Vui lòng nhập lại:");
            }
        }
//        Nhaapj tác giả
        System.out.println("Nhập tác giả :");
        while (true){
            author = scanner.nextLine();
            if (!author.isEmpty()){
                break;
            }else {
                System.err.println("Tên tác giả không được để trống. Vui lòng nhập lại:");
            }
        }
//       Nhaapjp mo ta
        System.out.println("Nhập mô tả về sách :");
        while (true){
            descriptions = scanner.nextLine();
            if (!descriptions.isEmpty() && descriptions.length() >= 10){
                break;
            }else {
                System.err.println("Lớn hơn 10 ký tự và không được để trống. Vui lòng nhập lại:");
            }
        }
//        nhập giá nhập
        System.out.println("Nhập giá nhập sách :");
        while (true){
            importPrice = Double.parseDouble(scanner.nextLine());
            if (importPrice > 0){
                break;
            }else {
                System.err.println("Giá nhập sai. Vui lòng nhập lại:");
            }
        }
//        nhập giá xuât

        System.out.println("Nhập giá xuất sách :");
        while (true){
            exportPrice = Double.parseDouble(scanner.nextLine());
            if (exportPrice > importPrice*1.2){
                break;
            }else {
                System.err.println("Giá xuất sai. Vui lòng nhập lại:");
            }
        }
    }

    //    Hiển thị
    public void displayData(){
        System.out.println("Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                ", interest=" + interest +
                ", bookStatus=" + bookStatus +
                '}');
        System.out.println("***********************************************");
    }

    public void calInterest() {
        interest = (float) (exportPrice - importPrice);
    }

}
