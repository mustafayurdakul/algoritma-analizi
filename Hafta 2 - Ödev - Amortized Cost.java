/*  

    Algoritma Analizi
    Hafta 2 - Ödev - DynamicArray

    Mustafa Yurdakul
    160401072
    yurdakulmustafa@outlook.com

     */

public class DynamicArray {
    int array[];
    int n;              // Eleman sayısı
    int capacity;       // Sizinin maksimum alabileceği eleman sayısı kapasite


    /*

        Constructor

        */
    public DynamicArray() {
        array = new int[2];
        n = 0;      
        capacity = 2;
    }

    /*
    
    Amortized Cost

    Yeni eleman eklenmesi için n eleman yeni diziye kopyalanacaktır. 2n elemanı eklemek için n adet kopyalama gerekmektedir.

    2n elemanın eklenmesi için: 
    
    2n işlem + n adet kopyalama = 3n

    Buna göre karmaşıklık:

    O(3n/2n) = O(3/2) = O(1)

    */

    
    
    public void append(int eleman) {
        /*

            Eğer kapasite yeterli değilse iki katına çıkartılıyor.

            */
        if (n == capacity) {
            int new_array[] = new int[capacity * 2];
          
            // complexity -> O(n)capacity
            for (int i = 0; i < capacity; i++) {
                new_array[i] = array[i];
            }
            array = new_array;
            capacity = capacity * 2;
        }
        array[n] = eleman;
        n++;
    }

    

    /*
    
        amortized cost -> O(1)

        */

    public void remove() {
        if (n > 0) {    // Eleman sayısı 0'dan büyükse silme işlemi yapılabilir.
            array[n - 1] = 0;
            n--;        // Eleman silindiğinde eleman sayısını azaltıyoruz 
        }
    }

    /*
        
        Yeniden boyutlandırma fonksiyonu

        */

    public void resize(int new_capacity) {
        int temp[] = new int[new_capacity];


        /*
            
            Bu fonksiyonda yeni kapasiteli bir dizi oluşturulup. Eski dizideki elemanlar yeni diziye atanıyor.

            */

        for (int i = 0; i < capacity; i++) {
            temp[i] = array[i];
        }

        array = temp;
        capacity = new_capacity;
    }

    public static void main(String args[]) {
        DynamicArray array = new DynamicArray();

        /*
        
            Mevcut dizinin kapasitesi ve eleman sayısı.

            */
            
        System.out.println("Number of elements:" + array.n + "  Capacity: " + array.capacity);

        /*
        
            Dizi sonundaki eleman eklendi. 5 adet çağırım yapıldı.

            */
        array.append(5);
        array.append(4);
        array.append(3);
        array.append(2);
        array.append(1);
        System.out.println("Number of elements:" + array.n + "  Capacity: " + array.capacity);
        
        /*
        
            Dizi sonundaki eleman silindi. 5 adet çağırım yapıldı.

            */ 
        array.remove();
        array.remove();
        array.remove();
        array.remove();
        array.remove();
        System.out.println("Number of elements:" + array.n + "  Capacity: " + array.capacity);
        
        /*
        
            Dizi yeniden boyutlandırıldı. 5 adet çağırım yapıldı.

            */ 
        array.resize(22);
        array.resize(28);
        array.resize(45);
        array.resize(53);
        array.resize(62);
        System.out.println("elaman sayısı:" + array.n + "  kapasite: " + array.capacity);
    }
}
