//Thuật toán tìm kiếm
package Slot9;

import java.util.Base64;

public class BinarySearch {
    int binarySearch(int arr[],int x){
        int l = 0,r=arr.length -1;
        while (l <= r){
            int m = l + (r - 1) / 2;

            //Kiểm tra x có phải ở giữa ko
            if (arr[m] ==x)
                return m;

            //Nếu x lớn hơn,bỏ qua nửa bên trái mảng
            if (arr[m] <x)
                l = m + 1;

            //Nếu x nhỏ hơn bỏ qua nửa bên phải của mảng

            else
                r = m - 1;
        }

        //Nếu không tìm thấy
        return -1;
    }
    public static void main(String[] args){
        BinarySearch bs = new BinarySearch();
        int arr[] = {2,6,4,10,50};
        int n = arr.length;
        int x = 10;
        int result = bs.binarySearch(arr,x);
        if (result == -1)
            System.out.println("Không tìm thấy phần tử");
        else
            System.out.println("Phần tử được tìm thấy tại chỉ số:"+ result);
    }
}
