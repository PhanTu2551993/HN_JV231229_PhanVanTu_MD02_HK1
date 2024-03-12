package ra.bussiness;

import java.util.Scanner;

public class BookManagement {
    private static Book[] books = new Book[100];
    private static int length = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(
                    "****************JAVAVAVA-HACKATATHON-05-BASIC-MENU***************\n" +
                            "1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách \n" +

                            "2. Hiển thị thông tin tất cả sách trong thư viện \n" +

                            "3. Sắp xếp sách theo lợi nhuận tăng dần \n" +

                            "4. Xóa sách theo mã sách \n" +

                            "5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả \n"+

                            "6. Thay đổi thông tin sách theo mã sách \n"+

                            "7. Thoát");
            System.out.println("Moi lua chon");
            int choice =  Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sách cần thêm mới: ");
                    addBooks(scanner);
                    break;
                case 2:
                        showAllBooks();
                    break;
                case 3:
                    selectionSortInterest();
                    break;
                case 4:
                    deleteBooks();
                    break;
                case 5:
                    searchBook();
                    break;
                case 6:
                    updateBook();
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }while (true);

    }

    public static void addBooks(Scanner scanner){
        int n = Integer.parseInt(scanner.nextLine());
        if (n <= 0 || n > 100) {
            System.out.println("Số lượng sách không hợp lệ. Vui lòng nhập lại.");
            return;
        }
        for (int i = length; i < length + n; i++) {
            System.out.println("Nhập thông tin cho cuốn sách thứ " + (i + 1) + ":");
            books[i] = new Book();
            books[i].inputData(scanner);
            books[i].calInterest();
        }
        length+=n;

    }

    public static void showAllBooks(){
        for (int i = 0; i < length; i++) {
            if (books[i] != null) {
                books[i].displayData();
            }
        }
    }

    public static void selectionSortInterest(){
        for (int i = 0; i < length - 1; i++) {
            if (books[i] != null) {
                int minIndex = i;
                for (int j = i + 1; j < length; j++) {
                    if (books[j] != null && books[j].getInterest() < books[minIndex].getInterest()){
                        minIndex = j;
                    }
                }
                Book temp = books[i];
                books[i]=books[minIndex];
                books[minIndex] = temp;
            }
        }
        System.out.println("Đã sắp xếp sản phẩm theo lợi nhuận tăng dần.");
    }


    public static void deleteBooks(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sách cần xóa:");
        int delProductId = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        for (int i = 0; i < length; i++) {
            if (books[i] != null && books[i].getBookId() == delProductId) {
                check = true;
                for (int j = i; j < length - 1; j++) {
                    books[j] = books[j + 1];
                }
                length--;
                System.out.println("Đã xóa sách có mã: " + delProductId);
                break;
            }
        }
        if (!check) {
            System.out.println("Không tìm thấy sách có mã: " + delProductId);
        }
    }

    public static void searchBook (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập tên sách cần tìm:");
        String inputName = scanner.nextLine();
        boolean checkName = false;
        for (int i = 0; i < length; i++) {
            if (books[i].getBookName().contains(inputName) || books[i].getDescriptions().contains(inputName)){
                books[i].displayData();
                checkName= true;
            }
        }if (!checkName){
            System.out.println("Không sách với tên cần tìm");
        }
    }

    public static void updateBook(){
        boolean checkID = false;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập mã sách muốn cập nhật thông tin: ");
            int inputBookId = Integer.parseInt(scanner.nextLine());
            if (inputBookId > 0) {
                checkID = true;
                boolean check = false;
                for (int i = 0; i < length; i++) {
                    if (books[i] != null && books[i].getBookId() == inputBookId){
                        check =true;
                        books[i].inputData(scanner);
                        books[i].calInterest();
                    }
                }
                if (!check){
                    System.err.println("Mã sách không có ");
                }
            } else {
                System.err.println("Mã sách không hợp lệ. Vui lòng nhập lại.");
            }
        } while (!checkID);
    }


}
