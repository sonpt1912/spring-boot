I, [core] Kha?i nie??m tight-coupling (lie?n ke??t ra?ng buo??c) va? ca?ch loosely coupled
1, Gi?i thi?u
- tight-coupling (liên k?t r?ng bu?c) là m?t khái ni?m trong java ám ch? vi?c m?i quan h? gi?a các class quá ch?t ch?. Khi yêu c?u thay ??i logic hay m?t class b? l?i d?n t?i ?nh h??ng t?i toàn b? các class liên quan ??n nó.
- Loosely-coupled là cách ám ch? vi?c làm gi?m b?t s? ph? thu?c gi?a các class v?i nhau.
VD: 
	1, B?n có m?t Class th?c thi m?t nhi?m v? c?c k? ph?c t?p, và m?t trong s? ?ó là vi?c s?p x?p d? li?u tr??c khi x? lý.

public class BubbleSortAlgorithm{

public void sort(int[] array) {
// TODO: Add your logic here
    System.out.println("?ã s?p x?p b?ng thu?t toán sx n?i b?t");
  }
}



public class VeryComplexService {
// t?o m?i 1 th?ng BubblesortAlgorithm
private BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
public VeryComplexService(){
}

public void complexBusiness(int array[]){
   bubbleSortAlgorithm.sort(array);
// TODO: logic here
  }
}

- V?i cách làm ? trên, VeryComplexService ?ã hoàn thi?n ???c nhi?m v?, tuy nhiên, khi có yêu c?u thay ??i thu?t toán s?p x?p sang QuickSort thì nghe v? chúng ta s? ph?i s?a l?i hoàn toàn 2 Class ? trên ( s?a logic ? BubbleSortAlgorithm và s?a l?i bi?n ? VeryComplexService )
- Ngoài ra BubbleSortAlgorithm s? ch? t?n t?i n?u VeryComplexService t?n t?i, vì VeryComplexService t?o ??i t??ng BubbleSortAlgorithm bên trong nó ( hay nói cách khác là s? s?ng ch?t c?a BubbleSortAlgorithm s? do VeryComplexService quy?t ??nh ), theo nh? cách impplement này, nó là liên k?t r?t ch?t v?i nhau
	2,  

public interface SortAlgorithm {
    /**
     * S?p x?p m?ng ??u vào
     * @param array
     */
    public void sort(int array[]);
}

public class BubbleSortAlgorithm implements SortAlgorithm{

    @Override
    public void sort(int[] array) {
        // TODO: Add your logic here
        System.out.println("?ã s?p x?p b?ng thu?t toán sx n?i b?t");
    }
}

public class VeryComplexService {
    private SortAlgorithm sortAlgorithm;
    public VeryComplexService(){
        sortAlgorithm = new BubbleSortAlgorithm();
    }

    public void complexBusiness(int array[]){
        sortAlgorithm.sort(array);
        // TODO: more logic here
    }
- V?i cách làm này, VeryComplexService s? ch? quan h? v?i m?t interface là SortAlgorithm v?i cách này thì m?i quan h? gi?m b?t s? liên k?t, nh?ng nó không thay ??i ???c vi?c thu?t toán v?n ?ang là BubbleSortAlgorithm
	3, cách 3
public interface SortAlgorithm {
     * S?p x?p m?ng ??u vào
    public void sort(int array[]);
}

public class BubbleSortAlgorithm implements SortAlgorithm{
    @Override
    public void sort(int[] array) {
        // TODO: Add your logic here
        System.out.println("?ã s?p x?p b?ng thu?t toán sx n?i b?t");
}}

public class QuicksortAlgorithm implements SortAlgorithm {
    @Override
    public void sort(int[] array) {
        // TODO: Add your logic here
        System.out.println("?ã s?p x?p b?ng thu?t sx nhanh");
}}

public class VeryComplexService {
    private SortAlgorithm sortAlgorithm;
    public VeryComplexService(SortAlgorithm sortAlgorithm){
        this.sortAlgorithm = sortAlgorithm;
    }

    public void complexBusiness(int array[]){
        sortAlgorithm.sort(array);
        // TODO: more logic here
    }
}
public static void main(String[] args) {
    SortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
    SortAlgorithm quickSortAlgorithm = new QuicksortAlgorithm();
    VeryComplexService business1 = new VeryComplexService(bubbleSortAlgorithm);
    VeryComplexService business2 = new VeryComplexService(quickSortAlgorithm);
}
- Cách th? ba này c?ng là cách ph? bi?n nh?t. M?i liên h? gi?a 2 Class ?ã “l?ng l?o” h?n tr??c r? nhi?u. VeryComplexService s? không quan tâm ??n thu?t toán s?p x?p là gì n?a, mà ch? c?n t?p trung vào nghi?p v?. Còn SortAlgorithm s? ???c ??a vào t? bên ngoài tùy theo nhu c?u s? d?ng.



