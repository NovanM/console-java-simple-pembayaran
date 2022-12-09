public class Mahasiswa {
    //membuat atribut dari mahasiswa
    String nama;
    int tagihan;
    String namaTagihan;
    Mahasiswa(String nama, int tagihan, String namaTagihan){
        this.nama = nama;
        this.tagihan = tagihan;
        this.namaTagihan = namaTagihan;
    }

    public void cekTagihan(){
        System.out.printf("Tagihan %s mahasiswa %s = Rp. %d",this.namaTagihan, this.nama, this.tagihan);
    }

    public void tambahTagihan(int jumlahTagihan){
        //ketika memasukan tagihan kurang dari nol contorh -20000, maka tidak valid
        if (jumlahTagihan < 0) {
            System.out.println(" Jumlah tagihan Yang anda masukan tidak valid");
        }else {
            this.tagihan += jumlahTagihan;
            System.out.println("Tagihan "+this.namaTagihan+" Sebesar Rp. "+ jumlahTagihan + " Di tambahkan ke Mahasiswa " + this.nama + " Total tagihan Saat ini = Rp. " +this.tagihan);
        }
    }

    public void bayarTagihan(int jumlahTagihan){
        //melakukan pengecekan ketika tagihan mahasiswa 0 maka tidak ada yang perlu dibayarkan
        if (this.tagihan == 0) {
            System.out.printf("Mahasiswa %s Tidak Ada Tagihan Yang Perlu DIbayarkan", this.nama);
        }
        //ketika memasukan tagihan kurang dari nol contorh -20000, maka tidak valid
        else if (jumlahTagihan  < 0) {
            System.out.println("Jumlah tagihan Yang anda masukan tidak valid");
        }else {
            this.tagihan -= jumlahTagihan;
            //melakukan update ketika yang di bayarkan sudah lunas atau tagihan 0 maka update data properti artibut namaTagihan
            if (this.tagihan == 0) {
                this.namaTagihan = "Tidak ada Tagihan";
            }
            System.out.println("Tagihan "+this.namaTagihan+ " Sebesar Rp. "+ jumlahTagihan + " Di Bayarkan ke Mahasiswa " + this.nama + " Total tagihan Saat ini = Rp. " +this.tagihan);
        }
    }


}
